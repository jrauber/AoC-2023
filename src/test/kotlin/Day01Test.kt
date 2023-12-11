package de.aoc

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import java.io.File

class Day01Test {

    inner class Data (val value: String, val result: Int)

    @Nested
    inner class PartOne {

        private fun data() = listOf(
            Data("1abc2", 12),
            Data("pqr3stu8vwx", 38),
            Data("a1b2c3d4e5f", 15),
            Data("treb7uchet", 77)
        )

        @Test
        fun testLineData() =
            data().forEach { elem -> assertEquals(elem.result, Day01(Day01.Mode.Part1).calcLineSum(elem.value)) }

        @Test
        fun testSum() =
            assertEquals(142, Day01(Day01.Mode.Part1).calcSum(data().map { data -> data.value }))

        @Test
        fun testFullDataSum() {
            val lines = File("src/main/resources/inputDay01.txt").readLines()

            assertEquals(56397, Day01(Day01.Mode.Part1).calcSum(lines))
        }
    }

    @Nested
    inner class PartTwo {

        private fun data() = listOf(
            Data("two1nine", 29),
            Data("eightwothree", 83),
            Data("abcone2threexyz", 13),
            Data("xtwone3four", 24),
            Data("4nineeightseven2", 42),
            Data("zoneight234", 14),
            Data("7pqrstsixteen", 76),
        )

        @Test
        fun testLineData() =
            data().forEach { elem -> assertEquals(elem.result, Day01(Day01.Mode.Part2).calcLineSum(elem.value)) }

        @Test
        fun testSum() =
            assertEquals(281, Day01(Day01.Mode.Part2).calcSum(data().map { data -> data.value }))

        @Test
        fun testFullDataSum() {
            val lines = File("src/main/resources/inputDay01.txt").readLines()

            assertEquals(55701, Day01(Day01.Mode.Part2).calcSum(lines))
        }

    }
}