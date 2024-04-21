package com.example.io.objectstream;

import java.io.*;
import java.util.Arrays;

public class SerializableExample {

    public static void main(String[] args) {
        // シリアライズ (直列化)
        // 独自定義したオブジェクトをオブジェクトのまま入出力できる
        showSimpleObjectStream();
        showComplicatedObjectStream();
    }

    static void showSimpleObjectStream() {
        Employee bob = new Employee(100, "bob");
        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("data.txt"))) {
            try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("data.txt"))) {
                os.writeObject(bob);
                Employee employee = (Employee) oi.readObject();
                System.out.println("######### single object #########");
                System.out.println(employee.getId());
                System.out.println(employee.getName());
                System.out.println("######### single object #########");
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    static void showComplicatedObjectStream() {
        Company company = new Company(new int[]{1, 2, 3}
                , new String[]{"bob", "alice", "fowler"}
                , new Employee(10, "greg")
                , Arrays.asList(
                new Employee(11, "parker")
                , new Employee(12, "carry")));

        try (ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("data_complicate.txt"))) {
            try (ObjectInputStream oi = new ObjectInputStream(new FileInputStream("data_complicate.txt"))) {
                os.writeObject(company);
                Company readCompany = (Company) oi.readObject();
                System.out.println("######### extends object #########");
                System.out.println(readCompany.getId());
                System.out.println(Arrays.toString(readCompany.getZipCode()));
                System.out.println(Arrays.toString(readCompany.getAddressName()));
                System.out.println(readCompany.getCeo().getName());
                readCompany.getMembers().stream()
                        .map(Employee::getName)
                        .forEach(System.out::println);
                System.out.println("######### extends object #########");
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
