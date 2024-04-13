package org.example.exception_handling;

import java.io.IOException;
import java.util.List;

public class Client {
    // Quote -> https://www.youtube.com/watch?v=1qdANLdLddk
    // Quote -> Exception Handling in Functional and Reactive Programming by Venkat Subramaniam
    public static void main(String[] args) {
        List<String> names = List.of("Alice", "Bob", "Richard");
        names.stream()
                .map(Client::tryGetRoomByName)
                .map(rs -> rs.map(String::toUpperCase))
                .map(rs -> switch (rs) { // 441: Pattern Matching for Switch
                    case Success data -> data.getResult();
                    case Failure error -> error.getError();
                })
                .forEach(System.out::println);

    }

    public static Try<String> tryGetRoomByName(String name) {
        // check 例外をTry interface内でwrapしている
        return Try.of(() -> getRoomByName(name));
    }

    public static String getRoomByName(String name) throws IOException {
        // imitate to access external resource
        if (name.contains("o")) {
            throw new IOException("Invalid name:" + name);
        }
        return "%s:%s".formatted(name, switch (name) {
            case "Alice" -> "At Corner";
            case "Bob" -> "Between toilet";
            case "Richard" -> "Roof";
            default -> "None";
        });
    }

}
