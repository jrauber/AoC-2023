package de.aoc

import java.util.OptionalInt


class Day01(val mode: Mode) {

    val numbers = listOf("one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "zero");

    enum class Mode {
        Part1,
        Part2
    }

    fun calcSum(line : List<String>) : Int =
        line.sumOf { l -> calcLineSum(l) }

    fun calcLineSum(line : String) : Int {
        var first = searchForward(line);
        var last = searchBackward(line);

        return (first.asInt * 10) + last.asInt;
    }

    fun searchForward(line: String): OptionalInt {

        for (i in line.indices) {
            val char = line[i];

            if (isDigit(char)) {
                return OptionalInt.of(char.digitToInt());
            } else {

                if (mode == Mode.Part2) {

                    var searchVal: String = char.toString();
                    var lookahead = 1;

                    while (i + lookahead < line.length) {

                        searchVal += line[i + lookahead];

                        var elemFound = false;
                        for (elem in numbers) {

                            if (elem.startsWith(searchVal)) {

                                if (elem.length == searchVal.length) {
                                    return textToDigit(searchVal);
                                }

                                elemFound = true;
                                lookahead++;
                            }
                        }

                        if (!elemFound) {
                            break;
                        }
                    }
                }
            }
        }

        return OptionalInt.empty();
    }

    fun searchBackward(line: String): OptionalInt {

        for (i in line.length - 1 downTo 0) {
            val char = line[i];

            if (isDigit(char)) {
                return OptionalInt.of(char.digitToInt());
            } else {

                if (mode == Mode.Part2) {

                    var searchVal: String = char.toString();
                    var lookahead = 1;

                    while (i + lookahead < line.length) {

                        searchVal += line[i + lookahead];

                        var elemFound = false;
                        for (elem in numbers) {

                            if (elem.startsWith(searchVal)) {

                                if (elem.length == searchVal.length) {
                                    return textToDigit(searchVal);
                                }

                                elemFound = true;
                                lookahead++;
                            }
                        }

                        if (!elemFound) {
                            break;
                        }
                    }
                }
            }
        }

        return OptionalInt.empty();
    }

    fun textToDigit(searchVal: String): OptionalInt =
        when (searchVal) {
            "one" -> OptionalInt.of(1)
            "two" -> OptionalInt.of(2)
            "three" -> OptionalInt.of(3)
            "four" -> OptionalInt.of(4)
            "five" -> OptionalInt.of(5)
            "six" -> OptionalInt.of(6)
            "seven" -> OptionalInt.of(7)
            "eight" -> OptionalInt.of(8)
            "nine" -> OptionalInt.of(9)
            "zero" -> OptionalInt.of(0)
            else -> OptionalInt.empty()
        }

    fun isDigit(char: Char): Boolean =
        when (char) {
            '1' -> true
            '2' -> true
            '3' -> true
            '4' -> true
            '5' -> true
            '6' -> true
            '7' -> true
            '8' -> true
            '9' -> true
            '0' -> true
            else -> false
        }
}