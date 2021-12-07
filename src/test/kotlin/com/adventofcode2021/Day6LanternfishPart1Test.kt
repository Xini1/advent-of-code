package com.adventofcode2021

import com.linesFromFile
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

/**
 * @author Maxim Tereshchenko
 */
internal class Day6LanternfishPart1Test {

    @Test
    fun answer() {
        assertThat(
            lanternfishAfter80Days(
                linesFromFile("2021/Day6LanternfishInput")
                    .flatMap { it.split(',') }
                    .map { it.toInt() }
            )
        )
            .isEqualTo(358214)
    }

    @Test
    fun `given 3 4 3 1 2, then return 5934`() {
        assertThat(
            lanternfishAfter80Days(
                sequenceOf(3, 4, 3, 1, 2)
            )
        )
            .isEqualTo(5934)
    }
}