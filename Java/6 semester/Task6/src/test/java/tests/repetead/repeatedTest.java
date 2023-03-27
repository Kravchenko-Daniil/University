package tests.repetead;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

public class repeatedTest {
    @DisplayName("Repeated test")
    @RepeatedTest(value = 3, name = "{displayName} = {currentRepitition} of {totalRepititions}")
    void repeated(){
        Assertions.assertTrue(0==0, "0==0");
    }
}
