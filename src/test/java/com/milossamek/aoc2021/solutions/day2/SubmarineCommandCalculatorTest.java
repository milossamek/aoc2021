package com.milossamek.aoc2021.solutions.day2;

import com.milossamek.aoc2021.solutions.base.AbstractCalculatorTest;
import com.milossamek.aoc2021.solutions.base.Calculator;
import com.milossamek.aoc2021.solutions.base.ResourceLoader;
import com.milossamek.aoc2021.solutions.day2.model.SubmarineCommand;



class SubmarineCommandCalculatorTest extends AbstractCalculatorTest<SubmarineCommand> {
    private final SubmarineCommandCalculator calculator = new SubmarineCommandCalculator();

    @Override
    public Calculator<SubmarineCommand> getCalculator() {
        return calculator;
    }

    @Override
    public ResourceLoader<SubmarineCommand> getResourceLoader() {
        return calculator;
    }

    @Override
    public String getDay() {
        return "day2";
    }

    @Override
    public long getExpectedResult() {
        return 2117664;
    }

    @Override
    public long getExpectedResultSmallSample() {
        return 150;
    }
}
