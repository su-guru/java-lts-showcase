package com.example;

import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Stream.of("c", "b", "a").sorted().forEach(System.out::println);
    }
}