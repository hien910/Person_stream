package com.example.person.DAO;

import com.example.person.database.PersonDB;
import com.example.person.model.Person;
import org.springframework.stereotype.Repository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class PersonRepository implements PersonRepositoryInterface {
    @Override
    public void printListPeople(List<Person> persons) {
        persons.forEach(System.out::println);
    }

    @Override
    public List<Person> getAll() {
        return PersonDB.personList.stream().toList();
    }

    @Override
    public List<Person> sortPeopleByFullName() {
        return PersonDB.personList.stream()
                .sorted((person1, person2) -> person1.getFullName().compareTo(person2.getFullName()))
                .toList();

    }

    @Override
    public List<Person> sortPeopleByFullNameReversed() {
        return PersonDB.personList.stream()
                .sorted((person1, person2) -> person2.getFullName().compareTo(person1.getFullName()))
                .toList();
    }

    @Override
    public List<String> getSortedJobs() {
        List<String> listJob =
                PersonDB.personList.stream()
                        .map(Person::getJob)
                        .sorted().toList();
        return listJob;
    }

    @Override
    public List<String> getSortedCities() {
        return PersonDB.personList.stream()
                .map(Person::getCity)
                .sorted().toList();
    }

    @Override
    public List<String> femaleNames() {
        return PersonDB.personList.stream()
                .filter(person -> person.getGender().equalsIgnoreCase("Female"))
                .map(Person::getFullName)
                .toList();
    }

    @Override
    public Person highestEarner() {
        return PersonDB.personList.stream()
                .max(Comparator.comparing(Person::getSalary))
                .orElse(null);

    }

    @Override
    public List<Person> bornAfter1990() {
        return PersonDB.personList.stream()
                .filter(person -> person.getBirthday().getYear() < 1990)
                .toList();
    }

    @Override
    public double averageSalary() {
        return PersonDB.personList.stream()
                .mapToDouble(Person::getSalary)
                .average().getAsDouble();
    }

    @Override
    public double averageAge() {
        return PersonDB.personList.stream()
                .mapToDouble(Person::getAge)
                .average().getAsDouble();
    }

    @Override
    public List<Person> nameContains(String keyword) {
        return PersonDB.personList.stream()
                .filter(p -> p.getFullName().equalsIgnoreCase(keyword))
                .toList();
    }

    @Override
    public List<Person> sortedByAgeForMale() {
        return PersonDB.personList.stream()
                .filter(p -> p.getGender().equals("Male"))
                .sorted((person1, person2) -> person2.getFullName().compareTo(person1.getFullName()))
                .toList();

    }

    @Override
    public Person longestName() {
        return PersonDB.personList.stream()
                .max(Comparator.comparing(person -> person.getFullName().length()))
                .orElse(null);
    }

    @Override
    public List<Person> aboveAverageSalary() {
        return PersonDB.personList.stream()
                .filter(person -> person.getSalary() > averageSalary()).toList();
    }

    @Override
    public Map<String, List<Person>> groupPeopleByCity() {
        return PersonDB.personList.stream()
                .collect(Collectors.groupingBy(
                        Person::getCity

                ));
    }

    @Override
    public Map<String, Long> groupJobByCount() {
        return PersonDB.personList.stream()
                .collect(Collectors.groupingBy(
                        Person::getJob, Collectors.counting()));

    }

    @Override
    public List<Person> inSalaryRange(int start, int end) {
        return PersonDB.personList.stream()
                .filter(person -> person.getSalary() >= start
                        && person.getSalary()<= end)
                .toList();
    }

    @Override
    public List<Person> startsWith(String prefix) {
        return PersonDB.personList.stream()
                .filter(p ->p.getFullName().startsWith(prefix))
                .toList();
    }

    @Override
    public List<Person> sortByBirthYearDescending() {
        return PersonDB.personList.stream()
                .sorted(Comparator.comparing(Person:: getBirthday).reversed()).toList();
    }

    @Override
    public List<Person> top5HighestPaid() {
        return PersonDB.personList.stream()
                .sorted(Comparator.comparing(Person::getSalary).reversed())
                .limit(5)
                .toList();
    }

    @Override
    public List<Person> inAgeRange(int start, int end) {
        return PersonDB.personList.stream()
                .filter(person -> person.getAge()>= start && person.getAge()<=end)
                .toList();
    }
}