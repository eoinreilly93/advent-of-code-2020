package com.advent.of.code.daytwo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class DayTwoTest {

  @Test
  void partOne() {
    assertEquals(580, DayTwo.partOne("src/test/resources/day_two_input.txt"));
  }

  @Test
  void partTwo() {
    assertEquals(611, DayTwo.partTwo("src/test/resources/day_two_input.txt"));
  }
}
