package com.example;

import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        // java 9 IntStream.iterate
        // rangeClosedより見やすい
        // [0]に初期値 [1]に後続の関数をつづける条件 [2]に条件まで続ける関数を渡す
        IntStream.iterate(1, year -> year < 10, year -> year + 1)
                .forEach(System.out::println);
    }
}