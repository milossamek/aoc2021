package com.milossamek.aoc2021.solutions.day2.model;

import java.util.Arrays;

public enum SubmarineDirection {
    FORWARD, DOWN, UP;

    public static SubmarineDirection fromString(String s) {
        return Arrays.stream(SubmarineDirection.values())
                .filter(rot -> rot.name().equalsIgnoreCase(s))
                .findFirst()
                .orElse(null);
    }


}
