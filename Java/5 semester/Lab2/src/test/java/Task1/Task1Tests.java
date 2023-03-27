package Task1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class Task1Tests {
    @Test
    @DisplayName("First test\n")
    void Test1(){
        Employee emp1 = new Employee("1", "YY", "WW", "Moscow", 2000,
                10000, false);
        Employee emp2 = new Employee("2", "NAME", "SURNAME", "Moscow", 9000,
                20000, false);
        assert (Employee.listEmployee.size() == 2);

    }
    @Test
    @DisplayName("Second test\n")
    void Test2(){
        Employee emp1 = new Employee("3", "Nikita", "Nikitin", "New York", 1000,
                2, true);
        Employee emp2 = new Employee("4", "Petr", "Petrov", "Moscow", 10000,
                1, true);
        assert (Employee.setOfIds.contains("3"));
    }
}
