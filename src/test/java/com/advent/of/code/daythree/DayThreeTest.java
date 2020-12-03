package com.advent.of.code.daythree;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(Lifecycle.PER_CLASS)
class DayThreeTest {

  private DayThree cut;

  @BeforeAll
  public void setup() throws IOException {
    this.cut = new DayThree("src/test/resources/day_three_input.txt");
  }

  @Test
  void partOne() throws IOException {
    assertEquals(207, this.cut.partOne());
  }

  @Test
  void partTwo() throws IOException {
    assertEquals(2655892800L, this.cut.partTwo());
  }
}
