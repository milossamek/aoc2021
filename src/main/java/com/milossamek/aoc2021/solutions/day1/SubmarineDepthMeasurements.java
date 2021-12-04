package com.milossamek.aoc2021.solutions.day1;

import lombok.SneakyThrows;
import org.springframework.util.ResourceUtils;

import java.nio.file.Files;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SubmarineDepthMeasurements {

    public long calculate(List<Integer> depths) {
        final AtomicInteger actualDepth = new AtomicInteger(depths.get(0));
        return depths.stream().skip(1).filter(depth -> {
            final boolean result = actualDepth.get() < depth;
            actualDepth.set(depth);
            return result;
        }).count();
    }

    @SneakyThrows
    public List<Integer> loadDepths(String filename) {
        try (Stream<String> lines = Files.lines(ResourceUtils.getFile(Objects.requireNonNull(this.getClass().getResource(filename))).toPath())) {
            return lines.map(Integer::valueOf).collect(Collectors.toList());
        }
    }
}
