package com.milossamek.aoc2021.solutions.day4.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.LinkedList;

@Data
@NoArgsConstructor
public class GameBoard {
    private List<Integer> drawnNumbers;
    private List<Board> boards = new LinkedList<>();
}
