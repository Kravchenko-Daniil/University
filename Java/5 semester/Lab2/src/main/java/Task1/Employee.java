package Task1;

import java.util.HashSet;
import java.util.Vector;

public class Employee{
    private String id, name, surname, birthPlace;
    private int birthYear, salary;
    private boolean isMarried;
    public static Vector<Employee> listEmployee = new Vector<Employee>(100);
    public static HashSet<String> setOfIds = new HashSet<>();

    public Employee(String id, String name, String surname, String birthPlace, int birthYear, int salary, boolean isMarried) {
        if (setOfIds.contains(id)){
            System.out.println("This id already exists");
        }
        else{
            this.id = id;
            this.name = name;
            this.surname = surname;
            this.birthPlace = birthPlace;
            this.birthYear = birthYear;
            this.salary = salary;
            this.isMarried = isMarried;
            listEmployee.add(this);
            setOfIds.add(id);
        }
    }
    public static void findById(String id){
        for(Employee emp: listEmployee ){
            if(emp.id.equals(id)){
                emp.dataPrint();
            }
        }
    }
    public void dataPrint(){
        System.out.println("Employee`s name: "+this.name);
        System.out.println("Employee`s surname: "+this.surname);
        System.out.println("Employee`s place of origin: "+this.birthPlace);
        System.out.println("Employee`s birth year: "+birthYear);
        System.out.println("Employee`s salary: "+salary);
        if(isMarried){
            System.out.println("Employee is married");
        }
        else{
            System.out.println("Employee is not married");
        }
    }
    public static void findByName(String name){
        for(Employee emp: listEmployee ){
            if(emp.name.equals(name)){
                emp.dataPrint();
            }
        }
    }
    public static void findByBirthYear(int birthYear){
        for(Employee emp: listEmployee ){
            if(emp.birthYear == birthYear){
                emp.dataPrint();
            }
        }
    }
    public static void printSalaries(){
        int Summ = 0;
        for(Employee emp: listEmployee){
            Summ += emp.salary;
        }
        System.out.println(Summ);
    }

//    public void setId(String id){
//        this.id = id;
//    }
//
//    public void setBirthPlace(String birthPlace) {
//        this.birthPlace = birthPlace;
//    }
//
//    public void setBirthYear(int birthYear) {
//        this.birthYear = birthYear;
//    }
//
//    public void setMarried(boolean married) {
//        isMarried = married;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public void setSalary(int salary) {
//        this.salary = salary;
//    }
//
//    public void setSurname(String surname) {
//        this.surname = surname;
//    }
}
