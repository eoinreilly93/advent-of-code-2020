package com.advent.of.code.daytwo;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class DayTwo {

  private static final Pattern p = Pattern.compile("(\\d+)-(\\d+)\\s(.):.(\\S+)");

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
    int count = 0;
    int min = 0;
    int max = 0;
    final Matcher m = p.matcher(line);
    if (m.find()) {
      min = Integer.parseInt(m.group(1));
      max = Integer.parseInt(m.group(2));
      final char value = m.group(3).charAt(0);
      final String password = m.group(4);

      for (final Character c : password.toCharArray()) {
        if (c == value) {
          count++;
        }
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
