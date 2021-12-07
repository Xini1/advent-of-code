package com.adventofcode2021

import com.linesFromFile
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

/**
 * @author Maxim Tereshchenko
 */
internal class Day7TheTreacheryOfWhalesPart1Test {

    @Test
    fun answer() {
        assertThat(
            leastFuelToAlign(
                linesFromFile("2021/Day7TheTreacheryOfWhalesInput")
                    .flatMap { it.split(',') }
                    .map { it.toInt() }
                    .toList()
            )
        )
            .isEqualTo(355521)
    }

    @Test
    fun `given 16 1 2 0 4 2 7 1 2 14, then return 37`() {
        assertThat(
            leastFuelToAlign(
                listOf(16, 1, 2, 0, 4, 2, 7, 1, 2, 14)
            )
        )
            .isEqualTo(37)
    }
}