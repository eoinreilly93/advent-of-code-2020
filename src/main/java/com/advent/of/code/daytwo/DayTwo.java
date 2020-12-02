package com.advent.of.code.daytwo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class DayTwo {

  public static int partOne(final String filename) {
    int count = 0;
    try (final Stream<String> stream = Files.lines(Paths.get(filename))) {
      count = (int) stream.filter(DayTwo::isValidPassword).count();

    } catch (final IOException e) {
      e.printStackTrace();
    }
    return count;
  }

  private static boolean isValidPassword(final String line) {
    final String[] array = line.split(" ");
    final int min = Integer.parseInt(array[0].split("-")[0]);
    final int max = Integer.parseInt(array[0].split("-")[1]);

    final String value = array[1].replace(":", "");
    final char value1 = value.charAt(0);
    final String password = array[2];

    int count = 0;
    for (final Character c : password.toCharArray()) {
      if (c == value1) {
        count++;
      }
    }

    return count >= min && count <= max;
  }

  public static int partTwo(final String filename) {
    int count = 0;
    try (final Stream<String> stream = Files.lines(Paths.get(filename))) {
      count = (int) stream.filter(DayTwo::isValidPassword2).count();

    } catch (final IOException e) {
      e.printStackTrace();
    }
    return count;
  }

  private static boolean isValidPassword2(final String line) {
    final String[] array = line.split(" ");
    final int min = Integer.parseInt(array[0].split("-")[0]);
    final int max = Integer.parseInt(array[0].split("-")[1]);

    final String value = array[1].replace(":", "");
    final char value1 = value.charAt(0);
    final String password = array[2];
    boolean valid = false;
    if (password.charAt(min - 1) == value1 && password.charAt(max - 1) == value1) {
      // do nothing
    } else if (password.charAt(min - 1) == value1 || password.charAt(max - 1) == value1) {
      valid = true;
    }
    return valid;
  }
}
