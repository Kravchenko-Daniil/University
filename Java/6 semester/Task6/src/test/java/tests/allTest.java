package tests;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({tests.dynamic.dynamicTest.class, tests.repetead.repeatedTest.class, tests.parameterized.parameterizedTest.class})
public class allTest {

}
