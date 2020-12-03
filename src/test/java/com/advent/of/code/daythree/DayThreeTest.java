package com.advent.of.code.daythree;

import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayThreeTest {

  @Test
  void partOne() throws IOException {
    assertEquals(7, DayThree.partOne("src/test/resources/day_three_input.txt"));
  }

  @Test
  void partTwo() {}
}
