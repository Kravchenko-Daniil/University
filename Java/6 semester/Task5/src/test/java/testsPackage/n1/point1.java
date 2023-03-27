package testsPackage.n1;

import org.junit.jupiter.api.*;

public class point1 {
    @BeforeEach
    void methodBeforeEach(){
        System.out.println("@BeforeEach");
    }

    @AfterEach
    void methodAfterEach(){
        System.out.println("@AfterEach");
    }

    @AfterAll
    static void methodAfterAll(){
        System.out.println("@AfterAll");
    }

    @Test
    @DisplayName("DisplayName1")
    @Tag("Tag1")
    void methodTest1(){
        Assertions.assertEquals(3, 2+1);
    }

    @Test
    @DisplayName("DisplayName2")
    @Tag("Tag2")
    @Disabled
    void methodTest2(){
        Assertions.assertEquals(4, 2+2);
    }
}
