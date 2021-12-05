package com.milossamek.aoc2021.solutions.day4.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class BingoNumber {
    private final int number;
    private boolean isSelected = false;
}
