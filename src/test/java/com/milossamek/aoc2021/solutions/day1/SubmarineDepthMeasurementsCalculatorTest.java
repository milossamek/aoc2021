package com.milossamek.aoc2021.solutions.day1;

import com.milossamek.aoc2021.solutions.base.AbstractCalculatorTest;
import com.milossamek.aoc2021.solutions.base.Calculator;
import com.milossamek.aoc2021.solutions.base.ResourceLoader;



class SubmarineDepthMeasurementsCalculatorTest extends AbstractCalculatorTest<Integer> {
    private final SubmarineDepthMeasurementsCalculator calculator = new SubmarineDepthMeasurementsCalculator();

    @Override
    public Calculator<Integer> getCalculator() {
        return calculator;
    }

    @Override
    public ResourceLoader<Integer> getResourceLoader() {
        return calculator;
    }

    @Override
    public String getDay() {
        return "day1";
    }

    @Override
    public long getExpectedResult() {
        return 1581;
    }

    @Override
    public long getExpectedResultSmallSample() {
        return 7;
    }
}
