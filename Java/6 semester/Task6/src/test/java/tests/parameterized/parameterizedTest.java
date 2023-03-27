package tests.parameterized;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class parameterizedTest {
    @ParameterizedTest(name = "{index} Test")
    @ValueSource(ints = {1, 2, 3})
    void parameterized(int i){
        Assertions.assertTrue(i == 2, "{0} == 2");
    }
}
