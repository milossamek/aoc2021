package com.milossamek.aoc2021.solutions.day4.model;

import lombok.Data;

import java.util.List;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

@Data
public class Board {
    private List<List<BingoNumber>> numbers = new LinkedList<>();

    public boolean hasBingo() {
        return hasRowBingo() || hasColumnBingo();
    }

    public void setBingoNumber(int number) {
        this.getNumbers().forEach(row -> row.stream().filter(bingoNumber -> bingoNumber.getNumber() == number).forEach(bingoNumber -> bingoNumber.setSelected(true)));
    }

    public int getSumOfAllNotDrawnNumbers() {
        final AtomicInteger sum = new AtomicInteger();
        numbers.forEach(row -> sum.set(sum.addAndGet(row.stream().filter(number -> !number.isSelected()).map(BingoNumber::getNumber).reduce(0, Integer::sum))));
        return sum.get();
    }

    private boolean hasColumnBingo() {
        boolean hasBingo;
        for (int i = 0; i < numbers.size(); i++) {
            hasBingo = true;
            for (int j = 0; j < numbers.get(i).size(); j++) {
                if (!numbers.get(j).get(i).isSelected()) {
                    hasBingo = false;
                    break;
                }
            }
            if (hasBingo) {
                return true;
            }
        }
        return false;
    }

    private boolean hasRowBingo() {
        boolean hasBingo;
        for (int i = 0; i < numbers.size(); i++) {
            hasBingo = true;
            for (int j = 0; j < numbers.get(i).size(); j++) {
                if (!numbers.get(i).get(j).isSelected()) {
                    hasBingo = false;
                    break;
                }
            }
            if (hasBingo) {
                return true;
            }
        }
        return false;
    }
}
