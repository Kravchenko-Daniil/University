package testsPackage.n2;

import org.example.Main;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class point3 {
    @Test
    void assertArrays(){
        char[] str1 = {'h', 'i'};
        Assertions.assertArrayEquals(str1, "hi".toCharArray());
    }

    @Test
    void assertIterable(){
        String str2 = "hello";
        ArrayList<Character> lst = new ArrayList<>(Arrays.asList(new Character[]{'h', 'e', 'l', 'l', 'o'}));
        Assertions.assertIterableEquals(lst, Main.returnIterable(str2));
    }

    @Test
    void assertLinesMatch(){
        String str3 = "today is cold";
        List list = List.of(new String[]{"today", "is", "cold"});
        Assertions.assertLinesMatch((java.util.List<String>) list, (java.util.List<String>) Main.returnLines(str3));
    }

    @Test
    void assertNotNull(){
        double n = 105.1;
        Assertions.assertNotNull(n);
    }

    @Test
    void assertSame(){
        Assumptions.assumeTrue(0 != 0);
        Double x = 13532452345.5;
        Double y = 13532452345.5;
        Assertions.assertSame(x, y);
    }

    @Test
    void assertTimeout(){
        Assertions.assertTimeout(Duration.ofMillis(1), () -> Main.Sleep(0));
    }

    @Test
    void assertTrhows(){
        Assertions.assertThrows(ArithmeticException.class, () -> Main.Throw());
    }

}
