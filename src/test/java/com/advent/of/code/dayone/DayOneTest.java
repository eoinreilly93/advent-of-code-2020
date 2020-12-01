package com.advent.of.code.dayone;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayOneTest {

  @Test
  void testPartOne() throws IOException {

    final List<Integer> input =
        Files.readAllLines(Paths.get("src/test/resources/day_one_input.txt")).stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    assertEquals(542619, DayOne.partOne(input));
  }

  @Test
  void testPartTwo() throws IOException {

    final List<Integer> input =
        Files.readAllLines(Paths.get("src/test/resources/day_one_input.txt")).stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    assertEquals(32858450, DayOne.partTwo(input));
  }
}
