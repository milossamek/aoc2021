package com.milossamek.aoc2021.solutions.day2.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class SubmarineCommand {
    private final SubmarineDirection submarineRotation;
    private final Integer move;
}
