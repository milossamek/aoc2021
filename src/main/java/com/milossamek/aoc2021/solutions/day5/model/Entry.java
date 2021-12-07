package com.milossamek.aoc2021.solutions.day5.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Entry {
    private int x1;
    private int x2;
    private int y1;
    private int y2;
}
