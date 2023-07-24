package sk.zrebec.acme.model;

import java.util.List;
import java.util.stream.Collectors;

public final class Acme extends Company {

    public Acme(List<Employee> employees) {
        super(employees);
    }

    public long averageEmployeesAge() {
        return (long) super.getAllEmployees().stream()
                .mapToDouble(Employee::getAge)
                .average()
                .orElse(0);
    }

    public List<Employee> getOlderEmployeesThan(int initialAge) {
        return super.getAllEmployees().stream().filter(employee ->
                employee.getAge() > initialAge).collect(Collectors.toList());
    }
}
