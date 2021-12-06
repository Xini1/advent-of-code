package com.adventofcode2021

import com.linesFromFile
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

/**
 * @author Maxim Tereshchenko
 */
internal class Day5HydrothermalVenturePart1Test {

    @Test
    fun answer() {
        assertThat(lineOverlappingPoints(linesFromFile("2021/Day5HydrothermalVentureInput"))).isEqualTo(5145)
    }

    @Test
    fun `given 10 lines, the return 5`() {
        assertThat(
            lineOverlappingPoints(
                sequenceOf(
                    "0,9 -> 5,9",
                    "8,0 -> 0,8",
                    "9,4 -> 3,4",
                    "2,2 -> 2,1",
                    "7,0 -> 7,4",
                    "6,4 -> 2,0",
                    "0,9 -> 2,9",
                    "3,4 -> 1,4",
                    "0,0 -> 8,8",
                    "5,5 -> 8,2"
                )
            )
        )
            .isEqualTo(5)
    }
}
