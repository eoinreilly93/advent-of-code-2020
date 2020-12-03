package com.advent.of.code.daythree;

import java.awt.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DayThree {
  private final char[][] map;

  public DayThree(final String filename) throws IOException {
    this.map =
        Files.readAllLines(Paths.get(filename)).stream()
            .map(String::toCharArray)
            .collect(Collectors.toList())
            .toArray(char[][]::new);
  }

  public int partOne() {
    return countTrees(this.map, 3, 1);
  }

  public long partTwo() {
    return Stream.of(
            new Point(1, 1), new Point(3, 1), new Point(5, 1), new Point(7, 1), new Point(1, 2))
        .mapToLong(slope -> countTrees(this.map, slope.x, slope.y))
        .reduce((a, b) -> a * b)
        .getAsLong();
  }

  private static int countTrees(final char[][] map, final int slopeX, final int slopeY) {
    int count = 0;
    final int width = map[0].length;
    final int height = map.length;

    int y = slopeY;
    int x = slopeX;

    // Continue to parse until vertically exiting the map bounds
    while (y < height) {
      count += map[y][x] == '#' ? 1 : 0;
      // Clamp the x coordinate to stay within horizontal map bounds
      x = (x + slopeX) % width;
      y += slopeY;
    }
    return count;
  }
}
