package com.advent.of.code.dayone;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

class DayOneTest {

  @Test
  public void testPartOne() throws IOException {

    final List<Integer> input =
        Files.readAllLines(Paths.get("src/test/resources/day_one_input.txt")).stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    System.out.println(DayOne.partOne(input));
  }

  @Test
  public void testPartTwo() throws IOException {

    final List<Integer> input =
        Files.readAllLines(Paths.get("src/test/resources/day_one_input.txt")).stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());

    System.out.println(DayOne.partTwo(input));
  }
}
