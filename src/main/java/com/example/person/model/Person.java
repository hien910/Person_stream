package com.example.person.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder

public class Person {
    private int id;
    private String fullName;
    private String job;
    private String gender;
    private String city;
    private int salary;
    private LocalDate birthday;

    public double getAge() {
        return LocalDate.now().getYear() - birthday.getYear();
    }
}
