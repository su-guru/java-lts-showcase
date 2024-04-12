package org.example;

import java.util.Comparator;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream.of(new Employee(1, "Bob")
                , new Employee(2, "Ted")
                , new Employee(3, "Alice"))
                .sorted(Comparator.comparing(Employee::name))
                .map(Employee::name)
                .forEach(System.out::println);
    }
    record Employee(Integer id, String name) {}
}