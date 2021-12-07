package com.adventofcode2021

import com.linesFromFile
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

/**
 * @author Maxim Tereshchenko
 */
internal class Day7TheTreacheryOfWhalesPart2Test {

    @Test
    fun answer() {
        assertThat(
            leastFuelToAlignWithIncreasingBurnRate(
                linesFromFile("2021/Day7TheTreacheryOfWhalesInput")
                    .flatMap { it.split(',') }
                    .map { it.toInt() }
                    .toList()
            )
        )
            .isEqualTo(100148777)
    }

    @Test
    fun `given 16 1 2 0 4 2 7 1 2 14, then return 168`() {
        assertThat(
            leastFuelToAlignWithIncreasingBurnRate(
                listOf(16, 1, 2, 0, 4, 2, 7, 1, 2, 14)
            )
        )
            .isEqualTo(168)
    }
}