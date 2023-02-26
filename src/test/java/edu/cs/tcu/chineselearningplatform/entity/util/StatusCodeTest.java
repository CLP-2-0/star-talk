package edu.cs.tcu.chineselearningplatform.entity.util;

import org.junit.Test;
import static org.junit.Assert.*;

public class StatusCodeTest {

    @Test
    public void testStatusCodeValues() {
        assertEquals(200, StatusCode.SUCCESS);
        assertEquals(400, StatusCode.FAILURE);
        assertEquals(401, StatusCode.UNAUTHORIZED);
        assertEquals(403, StatusCode.FORBIDDEN);
        assertEquals(404, StatusCode.NOT_FOUND);
        assertEquals(500, StatusCode.INTERNAL_SERVER_ERROR);
    }

}
