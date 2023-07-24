package sk.zrebec.acme;

import sk.zrebec.acme.model.Acme;
import sk.zrebec.acme.model.Employee;

import java.time.LocalDate;
import java.util.*;

public class Main {

    public static void main(String[] args) {
        List<Employee> employees = List.of(
        new Employee("John", "Smith", LocalDate.of(1980, 5, 15)),
        new Employee("Carla", "Jonathan", LocalDate.of(1996, 12, 1)),
        new Employee("Peter", "Max", LocalDate.of(1990, 1, 6))
        );

        Acme acme = new Acme(employees);
        System.out.println("List of Employees:");
        acme.addEmployee(new Employee("Thomas", "Rudger", LocalDate.of(1975, 7, 1)));

        acme.getEmployeeNames().forEach(System.out::println);
        System.out.println("\nAverage age: " + acme.averageEmployeesAge());

        System.out.println("\nEmployees older than 40 years");
        acme.getOlderEmployeesThan(40).forEach(employee -> System.out.println(employee.firstName() + " " + employee.lastName() + " has " + employee.getAge() + " years"));
    }
}