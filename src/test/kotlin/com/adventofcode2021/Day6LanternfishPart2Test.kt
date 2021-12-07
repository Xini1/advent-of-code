package com.adventofcode2021

import com.linesFromFile
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

/**
 * @author Maxim Tereshchenko
 */
internal class Day6LanternfishPart2Test {

    @Test
    fun answer() {
        assertThat(
            lanternfishAfter256Days(
                linesFromFile("2021/Day6LanternfishInput")
                    .flatMap { it.split(',') }
                    .map { it.toInt() }
            )
        )
            .isEqualTo(1622533344325)
    }

    @Test
    fun `given 3 4 3 1 2, then return 26984457539`() {
        assertThat(
            lanternfishAfter256Days(
                sequenceOf(3, 4, 3, 1, 2)
            )
        )
            .isEqualTo(26984457539)
    }
}