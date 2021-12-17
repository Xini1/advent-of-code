package com.adventofcode2021

import com.linesFromFile
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

internal class Day9SmokeBasinPart2Test {

    @Test
    fun answer() {
        assertThat(
            basinSizesMultiplied(
                linesFromFile("2021/Day9SmokeBasinInput")
                    .map {
                        it.asSequence()
                            .map { digit -> digit.digitToInt() }
                            .toList()
                    }
                    .toList()
            )
        )
            .isEqualTo(1269555)
    }

    @Test
    fun `given matrix, then return 1134`() {
        assertThat(
            basinSizesMultiplied(
                listOf(
                    listOf(2, 1, 9, 9, 9, 4, 3, 2, 1, 0),
                    listOf(3, 9, 8, 7, 8, 9, 4, 9, 2, 1),
                    listOf(9, 8, 5, 6, 7, 8, 9, 8, 9, 2),
                    listOf(8, 7, 6, 7, 8, 9, 6, 7, 8, 9),
                    listOf(9, 8, 9, 9, 9, 6, 5, 6, 7, 8)
                )
            )
        )
            .isEqualTo(1134)
    }
}