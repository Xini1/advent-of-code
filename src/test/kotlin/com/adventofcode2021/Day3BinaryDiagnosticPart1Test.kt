package com.adventofcode2021

import com.linesFromFile
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

/**
 * @author Maxim Tereshchenko
 */
internal class Day3BinaryDiagnosticPart1Test {

    @Test
    fun answer() {
        assertThat(
            powerConsumption(
                linesFromFile("2021/BinaryDiagnosticInput")
            )
        )
            .isEqualTo(3242606)
    }

    @Test
    fun `given 00100 11110 10110 10111 10101 01111 00111 11100 10000 11001 00010 01010, then return 198`() {
        assertThat(
            powerConsumption(
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
            .isEqualTo(198)
    }
}