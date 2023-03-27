package org.example;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CalculatorTests {
    @Test
    @DisplayName("testing multiplication operations (MyCalculator.multiply)")
    void testMultiplication() {
        assertTrue(Calculator.multiply(2.0, 3.0) == 6.0);
    }

    @Test
    @DisplayName("testing division operations (MyCalculator.divide)")
    void testDivision() {
        assertTrue(Calculator.divide(6.0, 3.0) == 2.0);
    }

    @Test
    @DisplayName("testing addition operations (MyCalculator.add)")
    void testAddition() {
        assertTrue(Calculator.add(6.0, 3.0) == 9.0);
    }

    @Test
    @DisplayName("testing subtraction operations (MyCalculator.subtract)")
    void testSubtraction() {
        assertTrue(Calculator.subtract(6.0, 3.0) == 3.0);
    }
}