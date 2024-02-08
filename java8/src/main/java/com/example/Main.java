package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> objects = new ArrayList<>();
        objects.add("c");
        objects.add("b");
        objects.add("a");
        objects.stream().sorted().forEach(System.out::println);
    }
}