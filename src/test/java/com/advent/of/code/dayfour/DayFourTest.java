package com.advent.of.code.dayfour;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class DayFourTest {

  private DayFour cut;

  @BeforeAll
  public void setup() {
    this.cut = new DayFour("src/test/resources/day_four_input.txt");
  }

  @Test
  void partOne() throws IOException {
    assertEquals(264, this.cut.partOne());
  }

  @Test
  void partTwo() throws IOException {
    assertEquals(2, this.cut.partTwo());
  }
}
