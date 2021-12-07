package com.milossamek.aoc2021.solutions.day5.model;

import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@Builder
public class RawHydrothermalVents {
    private final List<Entry> vents;
}
