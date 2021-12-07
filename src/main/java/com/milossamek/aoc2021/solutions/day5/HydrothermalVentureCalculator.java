package com.milossamek.aoc2021.solutions.day5;

import com.milossamek.aoc2021.solutions.base.Calculator;
import com.milossamek.aoc2021.solutions.base.ResourceLoader;
import com.milossamek.aoc2021.solutions.day5.model.Entry;
import com.milossamek.aoc2021.solutions.day5.model.RawHydrothermalVents;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class HydrothermalVentureCalculator extends ResourceLoader<RawHydrothermalVents> implements Calculator<RawHydrothermalVents> {

    public static final int MINIMAL_OVERLAP = 1;

    @Override
    public long calculate(List<RawHydrothermalVents> input) {
        final RawHydrothermalVents vents = input.get(0);
        final Venture venture = new Venture(getHighestCoordinates(vents));
        vents.getVents().forEach(entry -> {
            setYVents(venture, entry);
            setXVents(venture, entry);
        });
        return venture.getHigherThanCount(MINIMAL_OVERLAP);
    }

    private void setXVents(Venture venture, Entry entry) {
        if (entry.getY1() == entry.getY2()) {
            final Coordinates cord = getLinePosition(entry.getX1(), entry.getX2());
            IntStream.range(cord.getX(), cord.getY() + 1).forEach(x -> venture.invoke(entry.getY1(), x));
        }
    }

    private void setYVents(Venture venture, Entry entry) {
        if (entry.getX1() == entry.getX2()) {
            final Coordinates cord = getLinePosition(entry.getY1(), entry.getY2());
            IntStream.range(cord.getX(), cord.getY() + 1).forEach(x -> venture.invoke(x, entry.getX1()));
        }
    }

    private Coordinates getLinePosition(int first, int second) {
        return Coordinates
                .builder()
                    .x(Math.min(first, second))
                    .y(Math.max(first, second))
                .build();
    }

    private Coordinates getHighestCoordinates(RawHydrothermalVents rawHydrothermalVents) {
        return Coordinates
                .builder()
                    .x(rawHydrothermalVents.getVents().stream().mapToInt(entry -> Math.max(entry.getX1(), entry.getX2())).max().orElse(0))
                    .y(rawHydrothermalVents.getVents().stream().mapToInt(entry -> Math.max(entry.getY1(), entry.getY2())).max().orElse(0))
                .build();
    }

    @Override
    public Collection<RawHydrothermalVents> map(Stream<String> lines) {
        return Collections.singletonList(
                RawHydrothermalVents.builder()
                        .vents(lines.map(line -> {
                                    final String[] split = line.split(" -> ");
                                    final String[] left = split[0].split(",");
                                    final String[] right = split[1].split(",");
                                    return Entry.builder().x1(Integer.parseInt(left[0])).x2(Integer.parseInt(right[0])).y1(Integer.parseInt(left[1])).y2(Integer.parseInt(right[1])).build();
                                }).toList()
                        ).build()
        );
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    private static class Coordinates {
        private int x;
        private int y;
    }

    @Data
    private static class Venture {
        private List<List<HydrothermalVent>> vents;

        public Venture(Coordinates coordinates) {
            vents = IntStream.range(0, coordinates.getY() + 1).mapToObj(i -> new ArrayList<>(IntStream.range(0, coordinates.getY() + 1).mapToObj(y -> new HydrothermalVent()).toList())).collect(Collectors.toList());
        }

        private Long getHigherThanCount(int higherThan) {
            return vents.stream().map(vent -> vent.stream().filter(hydrothermalVent -> hydrothermalVent.getTimes() > higherThan).count()).reduce(Long::sum).orElse(0L);
        }

        private void invoke(int cord1, int cord2) {
            this.getVents().get(cord1).get(cord2).invoke();
        }
    }

    @Getter
    private static class HydrothermalVent {
        private int times;

        //inc times
        private void invoke() {
            times++;
        }
    }
}
