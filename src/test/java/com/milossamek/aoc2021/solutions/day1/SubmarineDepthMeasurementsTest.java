package com.milossamek.aoc2021.solutions.day1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubmarineDepthMeasurementsTest {
    private final SubmarineDepthMeasurements submarineDepthMeasurements = new SubmarineDepthMeasurements();

    @Test
    void testCalculate() {
        long result = submarineDepthMeasurements.calculate(submarineDepthMeasurements.loadDepths("/inputs/day1/input.txt"));
        assertEquals(1581, result);
    }

    @Test
    void testCalculateSmallSample() {
        long result = submarineDepthMeasurements.calculate(submarineDepthMeasurements.loadDepths("/inputs/day1/smallSample.txt"));
        assertEquals(7, result);
    }
}
