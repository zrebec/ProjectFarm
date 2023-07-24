package sk.zrebec.acme.model;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public sealed class Company permits Acme {

    private final List<Employee> employees;

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

    public List<Employee> getAllEmployees() {
        return employees;
    }
}
