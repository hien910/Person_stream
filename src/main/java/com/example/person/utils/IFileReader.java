package com.example.person.utils;

import com.example.person.model.Person;

import java.util.List;

public interface IFileReader {
    List<Person> readFile(String fileName);
}
