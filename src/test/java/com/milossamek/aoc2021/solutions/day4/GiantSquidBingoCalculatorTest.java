package com.milossamek.aoc2021.solutions.day4;

import com.milossamek.aoc2021.solutions.base.AbstractCalculatorTest;
import com.milossamek.aoc2021.solutions.base.Calculator;
import com.milossamek.aoc2021.solutions.base.ResourceLoader;
import com.milossamek.aoc2021.solutions.day4.model.GameBoard;


class GiantSquidBingoCalculatorTest extends AbstractCalculatorTest<GameBoard> {
    private final GiantSquidBingoCalculator calculator = new GiantSquidBingoCalculator();

    @Override
    public Calculator<GameBoard> getCalculator() {
        return calculator;
    }

    @Override
    public ResourceLoader<GameBoard> getResourceLoader() {
        return calculator;
    }

    @Override
    public String getDay() {
        return "day4";
    }

    @Override
    public long getExpectedResult() {
        return 74320;
    }

    @Override
    public long getExpectedResultSmallSample() {
        return 4512;
    }
}
