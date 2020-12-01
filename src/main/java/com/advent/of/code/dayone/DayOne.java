package com.advent.of.code.dayone;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DayOne {

  public static int partOne(final List<Integer> input) {
    return calculateValue(input, 2020);
  }

  public static int partTwo(final List<Integer> input) {
    int result = 0;
    for (int i = 0; i < input.size(); i++) {
      final int val = calculateValue(input.subList(i + 1, input.size()), 2020 - input.get(i));
      if (val != -1) {
        result = val * input.get(i);
        break;
      }
    }
    return result;
  }

  private static int calculateValue(final List<Integer> input, final int target) {
    // value, index
    final Map<Integer, Integer> map = new HashMap<>();
    int val = 0;

    for (final Integer i : input) {
      // We've seen this delta number already
      if (map.containsKey(i)) {
        // Get the index
        final int index = map.get(i);
        val = input.get(index);
        break;
      } else {
        final int delta = target - i;
        map.put(delta, input.indexOf(i));
      }
    }

    return val == 0 ? -1 : val * (target - val);
  }
}
