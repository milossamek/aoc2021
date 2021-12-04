package com.milossamek.aoc2021.solutions.day3;

import com.milossamek.aoc2021.solutions.base.Calculator;
import com.milossamek.aoc2021.solutions.base.ResourceLoader;
import lombok.Getter;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class BinaryDiagnosticCalculator extends ResourceLoader<String> implements Calculator<String> {
    @Override
    public long calculate(List<String> input) {
        final String gamma = buildGammaAndEpsilon(buildOccurrences(input));
        return computePowerConsumption(gamma, gamma.replace("0", "x").replace("1", "0").replace("x", "1"));
    }

    /**
     * Convert gamma & epsilon from binary to decimal and compute the power consumption
     *
     * @param gamma
     * @param epsilon
     * @return
     */
    private long computePowerConsumption(String gamma, String epsilon) {
        return (long) Integer.parseInt(gamma, 2) * Integer.parseInt(epsilon, 2);
    }

    private String buildGammaAndEpsilon(Map<Integer, Occurrences> occurrences) {
        return occurrences
                .values()
                .stream()
                .map(Occurrences::evaluate)
                .collect(Collectors.joining());
    }

    private Map<Integer, Occurrences> buildOccurrences(List<String> input) {
        final Map<Integer, Occurrences> occurrences = new HashMap<>();
        input.forEach(line ->
                IntStream.range(0, line.length())
                        .forEach(i -> {
                            occurrences.putIfAbsent(i, new Occurrences());
                            occurrences.computeIfPresent(i, (key, val) ->
                                    line.charAt(i) == '0' ? val.incOnes() : val.incZeros()
                            );
                        })
        );
        return occurrences;
    }

    @Override
    public Collection<String> map(Stream<String> lines) {
        return lines.toList();
    }

    @Getter
    private static class Occurrences {
        private int zeros = 0;
        private int ones = 0;

        public Occurrences incZeros() {
            zeros++;
            return this;
        }

        public Occurrences incOnes() {
            ones++;
            return this;
        }

        public String evaluate() {
            return this.getZeros() > this.getOnes() ? "0" : "1";
        }
    }
}
