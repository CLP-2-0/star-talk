package edu.cs.tcu.chineselearningplatform;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.extensions.jetty.auth.oauth2.LocalServerReceiver;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.googleapis.json.GoogleJsonResponseException;
import com.google.api.client.http.AbstractInputStreamContent;
import com.google.api.client.http.ByteArrayContent;
import com.google.api.client.http.FileContent;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.gson.GsonFactory;
import com.google.api.client.util.store.FileDataStoreFactory;
import com.google.api.services.drive.Drive;
import com.google.api.services.drive.DriveScopes;
import com.google.api.services.drive.model.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.GeneralSecurityException;
import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Calendar;
import com.google.api.services.drive.model.Permission;

/* class to demonstrate use of Drive files list API */
public class GoogleDrive {
    /**
     * Application name.
     */
    private static final String APPLICATION_NAME = "Google Drive API Java Quickstart";
    /**
     * Global instance of the JSON factory.
     */
    private static final JsonFactory JSON_FACTORY = GsonFactory.getDefaultInstance();
    /**
     * Directory to store authorization tokens for this application.
     */
    private static final String TOKENS_DIRECTORY_PATH = "src/main/resources/tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES =
            Collections.singletonList(DriveScopes.DRIVE_FILE);
    private static final String CREDENTIALS_FILE_PATH = "/credentials.json";

    /**
     * Creates an authorized Credential object.
     *
     * @param HTTP_TRANSPORT The network HTTP Transport.
     * @return An authorized Credential object.
     * @throws IOException If the credentials.json file cannot be found.
     */
    private static Credential getCredentials(final NetHttpTransport HTTP_TRANSPORT)
            throws IOException {
        // Load client secrets.
        InputStream in = GoogleDrive.class.getResourceAsStream(CREDENTIALS_FILE_PATH);
        if (in == null) {
            throw new FileNotFoundException("Resource not found: " + CREDENTIALS_FILE_PATH);
        }
        GoogleClientSecrets clientSecrets =
                GoogleClientSecrets.load(JSON_FACTORY, new InputStreamReader(in));

        // Build flow and trigger user authorization request.
        GoogleAuthorizationCodeFlow flow = new GoogleAuthorizationCodeFlow.Builder(
                HTTP_TRANSPORT, JSON_FACTORY, clientSecrets, SCOPES)
                .setDataStoreFactory(new FileDataStoreFactory(new java.io.File(TOKENS_DIRECTORY_PATH)))
                .setAccessType("offline")
                .build();
//        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setPort(8888).build();
        LocalServerReceiver receiver = new LocalServerReceiver.Builder().setHost("20.119.8.24").setPort(8888).build();
        Credential credential = new AuthorizationCodeInstalledApp(flow, receiver).authorize("user");
        //returns an authorized Credential object.
        return credential;
    }

    private byte[] writeFile(String base64, String username) throws IOException {
        byte[] decoded = Base64.getDecoder().decode(base64.split(",")[1].getBytes(StandardCharsets.UTF_8));
        return decoded;
    }

    private File generatePublicUrl(String id, Drive drive) throws IOException {
        File result = null;
        try {
            String fileId = id;
            Calendar calendar = Calendar.getInstance();
            long now = calendar.getTimeInMillis();

            // Set the expiration time to be 1 hour from now
            calendar.add(Calendar.HOUR_OF_DAY, 1);
            long oneHourLater = calendar.getTimeInMillis();

            Permission permission = new Permission()
                    .setType("anyone")
                    .setRole("reader")
                    .setExpirationTime(new com.google.api.client.util.DateTime(oneHourLater));

            drive.permissions().create(fileId, permission).execute();

            result = drive.files().get(fileId)
                    .setFields("webViewLink, webContentLink")
                    .execute();
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
        return result;
    }

    public String uploadFile(String base64, String username) throws IOException, GeneralSecurityException {
        byte[] decoded = writeFile(base64, username);
        // Build a new authorized API client service.
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Drive service = new Drive.Builder(HTTP_TRANSPORT, JSON_FACTORY, getCredentials(HTTP_TRANSPORT))
                .setApplicationName(APPLICATION_NAME)
                .build();

        // Upload file photo.jpg on drive.
        File fileMetadata = new File();
        fileMetadata.setName(username + ".mp3");
        // File's content.
        AbstractInputStreamContent mediaContent = new ByteArrayContent("audio/mp3", decoded);
        try {
            File file = service.files().create(fileMetadata, mediaContent)
                    .setFields("id,webContentLink, webViewLink")
                    .execute();
            System.out.println("File ID: " + file.getId());
            System.out.println("Link webview: " + file.getWebViewLink());
            System.out.println(("Link webContent: " + file.getWebContentLink()));
            File publicFile = generatePublicUrl(file.getId(), service);

            return file.getId();
        } catch (GoogleJsonResponseException e) {
            // TODO(developer) - handle error appropriately
            System.err.println("Unable to upload file: " + e.getDetails());
            throw e;
        }

    }

}
