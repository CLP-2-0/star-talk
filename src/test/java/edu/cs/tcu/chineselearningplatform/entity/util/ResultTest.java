package edu.cs.tcu.chineselearningplatform.entity.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ResultTest {

    @Test
    public void testResultConstructor() {
        Result result = new Result();
        assertNotNull(result);
    }

    @Test
    public void testResultConstructorWithoutData() {
        boolean expectedFlag = true;
        Integer expectedCode = 200;
        String expectedMessage = "Success";

        Result result = new Result(expectedFlag, expectedCode, expectedMessage);

        assertEquals(expectedFlag, result.isFlag());
        assertEquals(expectedCode, result.getCode());
        assertEquals(expectedMessage, result.getMessage());
        assertNull(result.getData());
    }

    @Test
    public void testFourArgConstructor() {
        boolean flag = true;
        Integer code = 200;
        String message = "Success";
        Object data = new Object();

        Result result = new Result(flag, code, message, data);

        assertEquals(flag, result.isFlag());
        assertEquals(code, result.getCode());
        assertEquals(message, result.getMessage());
        assertEquals(data, result.getData());
    }

    @Test
    public void testIsFlag() {
        Result result = new Result(true, 200, "Success");
        assertTrue(result.isFlag());

        result = new Result(false, 400, "Error");
        assertFalse(result.isFlag());
    }


    @Test
    public void testGetCode() {
        int expectedCode = 200;
        Result result = new Result(true, expectedCode, "Success");

        int actualCode = result.getCode();
        assertEquals(expectedCode, actualCode);
    }


    @Test
    public void testGetMessage() {
        Result result = new Result(false, 400, "Bad Request");

        assertEquals("Bad Request", result.getMessage());
    }


    @Test
    public void testGetData() {
        // Create a Result object with data
        Object expectedData = new Object();
        Result result = new Result(true, 200, "Success", expectedData);

        // Assert that the retrieved data matches the expected data
        Object actualData = result.getData();
        assertEquals(expectedData, actualData);
    }


}
