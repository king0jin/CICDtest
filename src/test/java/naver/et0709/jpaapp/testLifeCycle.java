package naver.et0709.jpaapp;

import org.junit.jupiter.api.*;

public class testLifeCycle {
    @Test
    public void test1() {
        System.out.println("test1");
    }
    @Test
    @DisplayName("test Case 2")
    public void test2() {
        System.out.println("test2");
    }
    @Disabled
    @Test
    @DisplayName("test Case 3")
    public void test3() {
        System.out.println("test3");
    }

    @BeforeAll
    static void setUpBeforeClass() {
        System.out.println("BeforeAll");
    }
    @AfterAll
    static void tearDownAfterClass() {
        System.out.println("AfterAll");
    }
    @BeforeEach
    void beforeEach() {
        System.out.println("BeforeEach");
    }
    @AfterEach
    void afterEach() {
        System.out.println("AfterEach");
    }
}
