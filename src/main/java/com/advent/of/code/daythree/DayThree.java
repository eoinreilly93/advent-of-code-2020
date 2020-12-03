package com.advent.of.code.daythree;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

public class DayThree {

  public static int partOne(final String filename) throws IOException {
    final char[][] map =
        Files.readAllLines(Paths.get(filename)).stream()
            .map(s -> s.toCharArray())
            .collect(Collectors.toList())
            .toArray(char[][]::new);

    return countTrees(map, 3, 1);
  }

  public void partTwo(final String filename) throws IOException {
    final char[][] map =
        Files.readAllLines(Paths.get(filename)).stream()
            .map(s -> s.toCharArray())
            .collect(Collectors.toList())
            .toArray(char[][]::new);
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
