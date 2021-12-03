package com.adventofcode2021

import com.linesFromFile
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

/**
 * @author Maxim Tereshchenko
 */
internal class Day3BinaryDiagnosticPart2Test {

    @Test
    fun answer() {
        assertThat(
            lifeSupport(
                linesFromFile("2021/BinaryDiagnosticInput")
                    .toList()
                    .asSequence()
            )
        )
            .isEqualTo(4856080)
    }

    @Test
    fun `given 00100 11110 10110 10111 10101 01111 00111 11100 10000 11001 00010 01010, then return 230`() {
        assertThat(
            lifeSupport(
                sequenceOf(
                    "00100",
                    "11110",
                    "10110",
                    "10111",
                    "10101",
                    "01111",
                    "00111",
                    "11100",
                    "10000",
                    "11001",
                    "00010",
                    "01010"
                )
            )
        )
            .isEqualTo(230)
    }
}