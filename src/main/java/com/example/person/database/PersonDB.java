package com.example.person.database;

import com.example.person.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class PersonDB {
    public static List<Person> personList;
}
