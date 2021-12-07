package com.milossamek.aoc2021.solutions.day5;

import com.milossamek.aoc2021.solutions.base.AbstractCalculatorTest;
import com.milossamek.aoc2021.solutions.base.Calculator;
import com.milossamek.aoc2021.solutions.base.ResourceLoader;
import com.milossamek.aoc2021.solutions.day5.model.RawHydrothermalVents;

class HydrothermalVentureCalculatorTest extends AbstractCalculatorTest<RawHydrothermalVents> {
    private final HydrothermalVentureCalculator calculator = new HydrothermalVentureCalculator();

    @Override
    public Calculator<RawHydrothermalVents> getCalculator() {
        return calculator;
    }

    @Override
    public ResourceLoader<RawHydrothermalVents> getResourceLoader() {
        return calculator;
    }

    @Override
    public String getDay() {
        return "day5";
    }

    @Override
    public long getExpectedResult() {
        return 4745;
    }

    @Override
    public long getExpectedResultSmallSample() {
        return 5;
    }
}
