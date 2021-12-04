package com.milossamek.aoc2021.solutions.base;

import lombok.SneakyThrows;
import org.springframework.util.ResourceUtils;

import java.nio.file.Files;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Stream;

public abstract class ResourceLoader<T> {

    @SneakyThrows
    public Collection<T> load(String fileName) {
        try (Stream<String> lines = Files.lines(ResourceUtils.getFile(Objects.requireNonNull(this.getClass().getResource(fileName))).toPath())) {
            return map(lines);
        }
    }
    public abstract Collection<T> map(Stream<String> lines);
}
