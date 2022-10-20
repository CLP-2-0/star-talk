package edu.cs.tcu.chineselearningplatform.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class DemoTest {

    @Test
    public void randomTest(){
        int num = 1;
        assertEquals(num, 1);
    }
}
