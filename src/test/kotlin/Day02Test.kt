package de.aoc

import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.File
import kotlin.test.assertEquals

class Day02Test {

    @Nested
    inner class PartOne {

        @Test
        fun checkExample() {

            val lines = File("src/main/resources/inputDay02Part1Example.txt").readLines()

            val data = lines.map { Day02().readLine(it) }.flatten()

            assertEquals(8, Day02().checkPart1(12, 13, 14, data));
        }

        @Test
        fun checkFullData() {

            val lines = File("src/main/resources/inputDay02.txt").readLines()

            var data = lines.map { Day02().readLine(it) }.flatten()

            assertEquals(2439, Day02().checkPart1(12, 13, 14, data));
        }
    }

    @Nested
    inner class PartTwo {

        @Test
        fun checkExample() {

            val lines = File("src/main/resources/inputDay02Part2Example.txt").readLines()

            val data = lines.map { Day02().readLine(it) }.flatten()

            assertEquals(2286, Day02().checkPart2(data));
        }

        @Test
        fun checkFullData() {

            val lines = File("src/main/resources/inputDay02.txt").readLines()

            val data = lines.map { Day02().readLine(it) }.flatten()

            assertEquals(63711, Day02().checkPart2(data));
        }

    }
}