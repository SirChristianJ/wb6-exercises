package com.pluralsight.streams;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        List<Person> fullList = new ArrayList<>();
        List<Person> filteredList = new ArrayList<>();

        fullList.add(new Person("Robbie", "Patton", 26));
        fullList.add(new Person("Scott", "Barnes", 21));
        fullList.add(new Person("Oliver", "Smith", 42));
        fullList.add(new Person("Liam", "Brown", 54));
        fullList.add(new Person("Sophia", "Martinez", 31));
        fullList.add(new Person("James", "Anderson", 27));
        fullList.add(new Person("Mia", "Thomas", 46));
        fullList.add(new Person("Benjamin", "White", 26));
        fullList.add(new Person("Amelia", "Harris", 38));
        fullList.add( new Person("Emma", "Johnson", 62));
        fullList.add( new Person("Dwayne", "Johnson", 52));


        System.out.println("Search for a name (first or last): ");
        String promptSearch = scanner.nextLine();

        /*for (Person person: fullList){
            if (person.getFirstName().equalsIgnoreCase(promptSearch) || person.getLastName().equalsIgnoreCase(promptSearch)){
                filteredList.add(person);
            }
        }*/

        fullList.stream().filter(person -> person.getLastName().equalsIgnoreCase(promptSearch) || person.getFirstName().equalsIgnoreCase(promptSearch))
                .toList().forEach(System.out::println);




        int totalAge = fullList.stream().map(person -> person.getAge())
                .reduce(0, (prevOutput,age) -> prevOutput + age);

        long count = fullList.stream().count();


        System.out.printf("\nAverage Age: %.2f", (double) totalAge/count);
    }
}