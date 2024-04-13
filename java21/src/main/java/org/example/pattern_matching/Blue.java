package org.example.pattern_matching;

public class Blue implements Color {
    @Override
    public String getName() {
        return getMore() + "BlueSky";
    }

    private String getMore() {
        return "excellent";
    }
}
