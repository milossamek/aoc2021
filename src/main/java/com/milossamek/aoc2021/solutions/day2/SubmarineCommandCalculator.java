package com.milossamek.aoc2021.solutions.day2;

import com.milossamek.aoc2021.solutions.base.Calculator;
import com.milossamek.aoc2021.solutions.day2.model.SubmarineCommand;
import com.milossamek.aoc2021.solutions.day2.model.SubmarineDirection;
import com.milossamek.aoc2021.solutions.base.ResourceLoader;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class SubmarineCommandCalculator extends ResourceLoader<SubmarineCommand> implements Calculator<SubmarineCommand> {

    @Override
    public long calculate(List<SubmarineCommand> commands) {
        final AtomicInteger horizontal = new AtomicInteger();
        final AtomicInteger depth = new AtomicInteger();
        commands.forEach(command -> {
            switch (command.getSubmarineRotation()) {
                case FORWARD -> horizontal.addAndGet(command.getMove());
                case DOWN ->depth.addAndGet(command.getMove());
                case UP -> depth.addAndGet(-command.getMove());
            }
        });
        return (long) horizontal.get() * depth.get();
    }

    @Override
    public Collection<SubmarineCommand> map(Stream<String> lines) {
        return lines.map(line -> {
            final String[] s = line.split(" ");
            return new SubmarineCommand(SubmarineDirection.fromString(s[0]), Integer.parseInt(s[1]));
        }).toList();
    }

}
