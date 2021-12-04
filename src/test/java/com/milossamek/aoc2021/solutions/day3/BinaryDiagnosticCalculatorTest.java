package com.milossamek.aoc2021.solutions.day3;

import com.milossamek.aoc2021.solutions.base.AbstractCalculatorTest;
import com.milossamek.aoc2021.solutions.base.Calculator;
import com.milossamek.aoc2021.solutions.base.ResourceLoader;

class BinaryDiagnosticCalculatorTest extends AbstractCalculatorTest<String> {
    private final BinaryDiagnosticCalculator calculator = new BinaryDiagnosticCalculator();

    @Override
    public Calculator<String> getCalculator() {
        return calculator;
    }

    @Override
    public ResourceLoader<String> getResourceLoader() {
        return calculator;
    }

    @Override
    public String getDay() {
        return "day3";
    }

    @Override
    public long getExpectedResult() {
        return 741950;
    }

    @Override
    public long getExpectedResultSmallSample() {
        return 198;
    }
}
