package com.adventofcode2021

import com.linesFromFile
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

/**
 * @author Maxim Tereshchenko
 */
internal class Day1SonarSweepPart1Test {

    @Test
    fun answer() {
        assertThat(
            measurementsLargerThanPreviousMeasurement(
                linesFromFile("2021/SonarSweepInput")
                    .map { it.toInt() }
            )
        )
            .isEqualTo(1390)
    }

    @Test
    fun `given single measurement, then return 0`() {
        assertThat(measurementsLargerThanPreviousMeasurement(sequenceOf(1))).isEqualTo(0)
    }

    @Test
    fun `given 1 2, then return 1`() {
        assertThat(measurementsLargerThanPreviousMeasurement(sequenceOf(1, 2))).isEqualTo(1)
    }

    @Test
    fun `given 1 2 3, then return 2`() {
        assertThat(measurementsLargerThanPreviousMeasurement(sequenceOf(1, 2, 3))).isEqualTo(2)
    }

    @Test
    fun `given 3 2 1, then return 0`() {
        assertThat(measurementsLargerThanPreviousMeasurement(sequenceOf(3, 2, 1))).isEqualTo(0)
    }
}