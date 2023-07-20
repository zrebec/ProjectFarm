package sk.zrebec.java.learning.farm;

import java.time.LocalDate;
import java.time.Period;
import java.util.*;
import java.util.stream.Collectors;

record Employee(String firstName, String lastName, LocalDate birthdate) {
    public int getAge() {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

    public String getName() {
        return firstName + " " + lastName;
    }
}

class Company {
    List<Employee> employees;

    public Company() {
        this.employees = new ArrayList<>();
    }
    public Company(List<Employee> employees) {
        this.employees = new ArrayList<>(employees);
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<String> getEmployeeNames() {
        return employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
    }

    public long averageEmployeesAge() {
        return (long) employees.stream()
                .mapToDouble(Employee::getAge)
                .average()
                .orElse(0);
    }

    public List<Employee> getOlderEmployeesThan(int initialAge) {
        return employees.stream().filter(employee -> employee.getAge() > initialAge).collect(Collectors.toList());
    }
}

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
        new Employee("John", "Smith", LocalDate.of(1980, 5, 15)),
        new Employee("Carla", "Jonathan", LocalDate.of(1996, 12, 1)),
        new Employee("Peter", "Max", LocalDate.of(1990, 1, 6))
        );

        Company acme = new Company(employees);
        System.out.println("List of Employees:");
        acme.addEmployee(new Employee("Thomas", "Rudger", LocalDate.of(1975, 7, 1)));

        acme.getEmployeeNames().forEach(System.out::println);
        System.out.println("\nAverage age: " + acme.averageEmployeesAge());

        System.out.println("\nEmployees older than 40 years");
        acme.getOlderEmployeesThan(40).forEach(employee -> System.out.println(employee.firstName() + " " + employee.lastName() + " has " + employee.getAge() + " years"));
    }
}