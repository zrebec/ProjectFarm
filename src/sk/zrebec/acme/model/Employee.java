package sk.zrebec.acme.model;

import java.time.LocalDate;
import java.time.Period;

public record Employee(String firstName, String lastName, LocalDate birthdate) {
    public int getAge() {
        return Period.between(birthdate, LocalDate.now()).getYears();
    }

    public String getName() {
        return firstName + " " + lastName;
    }
}