package com.adventofcode

import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

/**
 * @author Maxim Tereshchenko
 */
internal class SonarSweepPart2Test {

    @Test
    fun `given single window, then return 0`() {
        assertThat(measurementsInWindowLargerThanInPreviousWindow(sequenceOf(1, 2, 3))).isEqualTo(0)
    }

    @Test
    fun `given 1 2 3 4, then return 1`() {
        assertThat(measurementsInWindowLargerThanInPreviousWindow(sequenceOf(1, 2, 3, 4))).isEqualTo(1)
    }

    @Test
    fun `given 1 2 3 4 5, then return 2`() {
        assertThat(measurementsInWindowLargerThanInPreviousWindow(sequenceOf(1, 2, 3, 4, 5))).isEqualTo(2)
    }

    @Test
    fun `given 199 200 208 210 200 207 240 269 260 263, then return 5`() {
        assertThat(
            measurementsInWindowLargerThanInPreviousWindow(
                sequenceOf(199, 200, 208, 210, 200, 207, 240, 269, 260, 263)
            )
        )
            .isEqualTo(5)
    }
}