package com.milossamek.aoc2021.solutions.base;

import java.util.List;

public interface Calculator<T> {
    long calculate(List<T> input);
}
