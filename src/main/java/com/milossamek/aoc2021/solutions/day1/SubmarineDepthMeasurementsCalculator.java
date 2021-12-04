package com.milossamek.aoc2021.solutions.day1;

import com.milossamek.aoc2021.solutions.base.Calculator;
import com.milossamek.aoc2021.solutions.base.ResourceLoader;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class SubmarineDepthMeasurementsCalculator extends ResourceLoader<Integer> implements Calculator<Integer>{

    public long calculate(List<Integer> depths) {
        final AtomicInteger actualDepth = new AtomicInteger(depths.get(0));
        return depths.stream().skip(1).filter(depth -> {
            final boolean result = actualDepth.get() < depth;
            actualDepth.set(depth);
            return result;
        }).count();
    }

    @Override
    public List<Integer> map(Stream<String> lines) {
        return lines.map(Integer::valueOf).toList();
    }

}
