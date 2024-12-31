package naver.et0709.jpaapp;

import naver.et0709.jpaapp.service.Calulator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CalulatorTest {
    private Calulator calulator = new Calulator();

    @Test
    public void testSum() {
        assertEquals(Integer.valueOf(10), calulator.sum(4, 6));
    }
}