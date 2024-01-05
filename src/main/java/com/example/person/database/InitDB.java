package com.example.person.database;

import com.example.person.model.Person;
import com.example.person.utils.IFileReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class InitDB implements CommandLineRunner {

    @Autowired
    private IFileReader fileReader;

    private final String PERSON_DATA_FILE = "person.csv";

    @Override
    public void run(String... args) {
        PersonDB.personList = loadDataFromCSV(PERSON_DATA_FILE);
    }

    private List<Person> loadDataFromCSV(String fileName) {
        return fileReader.readFile(fileName);
    }
}
