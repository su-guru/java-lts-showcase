package org.example.pattern_matching;

public class Client {
    public static void main(String[] args) {
        System.out.println(decideColor("R"));
        System.out.println(decideColor(null));
        System.out.println(decideColor("E"));

        System.out.println(decideColorNameByPattern("R"));
        System.out.println(decideColorNameByPattern(null));
        System.out.println(decideColorNameByPattern(new Blue()));
        System.out.println(decideColorNameByPattern(new Green()));
    }

    public static String decideColor(String code) {
        return switch (code) {
            case "R" -> "RedWine";
            case null -> "Don't give null!"; // nullのときに返却する値を書ける
            default -> "Blue";
        };
    }

    public static String decideColorNameByPattern(Object o) {
        // 型によった分岐が可能
        return switch (o) {
            case Red r -> r.getName();
            case Blue b -> b.getName();
            case Green g -> g.getMoreTransparentName();
            case null -> "Don't give null!";
            case String s -> s.isEmpty() ? "Don't give empty!": s.toLowerCase();
            default -> "Transparent";
        };
    }
}
