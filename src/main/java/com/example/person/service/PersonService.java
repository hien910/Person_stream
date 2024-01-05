package com.example.person.service;

import com.example.person.DAO.PersonRepository;
import com.example.person.database.PersonDB;
import com.example.person.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public void printListPeople() {
        personRepository.printListPeople(PersonDB.personList);
    }

    public List<Person> getAll() {
        return personRepository.getAll();
    }

    public List<Person> sortPeopleByFullName() {
        return personRepository.sortPeopleByFullName();
    }

    public List<Person> sortPeopleByFullNameReversed() {
        return personRepository.sortPeopleByFullNameReversed();
    }

    public List<String> getSortedJobs() {
        return personRepository.getSortedJobs();
    }

    public List<String> getSortedCities() {
        return personRepository.getSortedCities();
    }

    public List<String> femaleNames() {
        return personRepository.femaleNames();

    }

    public Person highestEarner() {
        return personRepository.highestEarner();
    }

    public List<Person> bornAfter1990() {
        return personRepository.bornAfter1990();
    }

    public double averageSalary() {
        return personRepository.averageSalary();
    }

    public double averageAge() {
        return personRepository.averageAge();
    }


    public List<Person> nameContains(String keyword) {
        return personRepository.nameContains(keyword);
    }


    public List<Person> sortedByAgeForMale() {
        return personRepository.sortedByAgeForMale();
    }

    public Person longestName() {
        return personRepository.longestName();
    }

    public List<Person> aboveAverageSalary() {
        return personRepository.aboveAverageSalary();
    }


    public Map<String, List<Person>> groupPeopleByCity() {
        return personRepository.groupPeopleByCity();
    }

    public Map<String, Long> groupJobByCount() {
        return personRepository.groupJobByCount();
    }


    public List<Person> inSalaryRange(int a, int b) {
        return personRepository.inSalaryRange(a,b);
    }

    public List<Person> startsWith(String a) {
        return personRepository.startsWith(a);
    }

    public List<Person> sortByBirthYearDescending() {
        return personRepository.sortByBirthYearDescending();
    }

    public List<Person> top5HighestPaid() {
        return personRepository.top5HighestPaid();
    }

    public List<Person> inAgeRange(int start, int end) {
        return personRepository.inAgeRange(start,end);
    }
}
