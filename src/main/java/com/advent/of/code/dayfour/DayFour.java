package com.advent.of.code.dayfour;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DayFour {

  private static final List<String> REQUIRED =
      List.of("byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid");
  private static final Pattern byr = Pattern.compile("^(19[2-9][0-9]|200[0-2])$");
  private static final Pattern iyr = Pattern.compile("^(201[0-9]|2020)$");
  private static final Pattern eyr = Pattern.compile("^(202[0-9]|2030)$");
  private static final Pattern hgt =
      Pattern.compile("^(1[5-8][0-9]|19[0-3])cm|((59|6[0-9]|7[0-6])in)$");
  private static final Pattern hcl = Pattern.compile("^#[0-9a-f]{6}$");
  private static final Pattern ecl = Pattern.compile("^(amb|blu|brn|gry|grn|hzl|oth)$");
  private static final Pattern pid = Pattern.compile("^[0-9]{9}$");
  private static final Map<String, Pattern> validators = new HashMap<>();
  private final String filename;

  public DayFour(final String filename) {
    this.filename = filename;
  }

  static {
    validators.put("byr", byr);
    validators.put("iyr", iyr);
    validators.put("eyr", eyr);
    validators.put("hgt", hgt);
    validators.put("hcl", hcl);
    validators.put("ecl", ecl);
    validators.put("pid", pid);
  }

  public long partOne() throws IOException {
    final String[] passports = Files.readString(Paths.get(this.filename)).split("\n\n");
    return Stream.of(passports)
        .map(s -> s.split(" |\n"))
        .map(DayFour::makePassport)
        .filter(DayFour::isValid)
        .count();
  }

  private static Map<String, String> makePassport(final String[] tokens) {
    return Stream.of(tokens).map(t -> t.split(":")).collect(Collectors.toMap(s -> s[0], s -> s[1]));
  }

  private static boolean isValid(final Map<String, String> passports) {
    return passports.keySet().containsAll(REQUIRED);
  }

  public long partTwo() throws IOException {
    final String[] passports = Files.readString(Paths.get(this.filename)).split("\n\n");
    return Stream.of(passports)
        .map(s -> s.split(" |\n"))
        .map(DayFour::makePassport)
        .filter(DayFour::isValid)
        .filter(DayFour::strictValidation)
        .count();
  }

  private static boolean strictValidation(final Map<String, String> passports) {
    for (final Map.Entry<String, Pattern> validator : validators.entrySet()) {
      final String value = passports.get(validator.getKey());
      if (!validator.getValue().matcher(value).matches()) {
        return false;
      }
    }
    return true;
  }
}
