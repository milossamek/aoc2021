package com.milossamek.aoc2021.solutions.base;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public abstract class AbstractCalculatorTest<T> {
    public abstract Calculator<T> getCalculator();
    public abstract ResourceLoader<T> getResourceLoader();
    public abstract String getDay();
    public abstract long getExpectedResult();
    public abstract long getExpectedResultSmallSample();

    @Test
    void testCalculate() {
        long result = getCalculator().calculate(new ArrayList<>(getResourceLoader().load(String.format("/inputs/%s/input.txt", getDay()))));
        assertEquals(getExpectedResult(), result);
    }

    @Test
    void testCalculateSmallSample() {
        long result = getCalculator().calculate(new ArrayList<>(getResourceLoader().load(String.format("/inputs/%s/smallSample.txt", getDay()))));
        assertEquals(getExpectedResultSmallSample(), result);
    }
}
