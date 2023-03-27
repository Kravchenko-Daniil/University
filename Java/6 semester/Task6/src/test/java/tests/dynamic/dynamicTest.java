package tests.dynamic;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

import java.util.Arrays;
import java.util.Collection;

public class dynamicTest {
    @TestFactory
    Collection<DynamicTest> dynamicTestsWithCollection() {
        return Arrays.asList(
                DynamicTest.dynamicTest("Add test",
                        () -> Assertions.assertEquals(2, Math.addExact(1, 1))),
                DynamicTest.dynamicTest("Multiply Test",
                        () -> Assertions.assertEquals(4, Math.multiplyExact(2, 2))));
    }
}
