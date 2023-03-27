package Task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Employee leonardo, raphael, donatello, michelangelo, newEmployee;
        leonardo = new Employee("1", "Leonardo", "Blue", "New York",
                1991, 100000, false);
        raphael = new Employee("2", "Raphael", "Red", "Saint Petersburg",
                1992, 200000, true);
        donatello = new Employee("3", "Donatello", "Purple", "Moscow",
                1993, 50000, true);
        michelangelo = new Employee("4", "Michelangelo", "Orange", "Chicago",
                1994, 500000, false);

        System.out.println("Write new employee`s id:");
        String newEmployee_id = scanner.nextLine();
        System.out.println("Write new employee`s name:");
        String newEmployee_name = scanner.nextLine();
        System.out.println("Write new employee`s surname:");
        String newEmployee_surname = scanner.nextLine();
        System.out.println("Write new employee`s place of origin:");
        String newEmployee_place = scanner.nextLine();
        System.out.println("Write new employee`s birth year:");
        int newEmployee_year =  scanner.nextInt();
        System.out.println("Write new employee`s salary:");
        int newEmployee_salary =  scanner.nextInt();
        System.out.println("Is new employee married?:");
        boolean newEmployee_marital = scanner.nextBoolean();
        newEmployee = new Employee(newEmployee_id, newEmployee_name, newEmployee_surname, newEmployee_place,
                newEmployee_year, newEmployee_salary, newEmployee_marital);

        System.out.println("\nWrite id to find:");
        String id_find = scanner.nextLine();
        try {
            Employee.findById(id_find);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\nWrite the name to find:");
        String name_find = scanner.nextLine();
        try {
            Employee.findByName(name_find);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\nWrite birth year to find: ");
        int find_birthYear = scanner.nextInt();
        try {
            Employee.findByBirthYear(find_birthYear);
        }
        catch (Exception e) {
            System.out.println(e);
        }

        System.out.println("\nAmount of salaries:");
        Employee.printSalaries();

    }
}
