package com.adventofcode2015

import com.linesFromFile
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

/**
 * @author Maxim Tereshchenko
 */
internal class Day2IWasToldThereWouldBeNoMathPart1Test {

    @Test
    fun answer() {
        assertThat(
            wrappingPaperSquareFeet(
                linesFromFile("2015/IWasToldThereWouldBeNoMathInput")
                    .map { it.split("x") }
                    .map { Triple(it[0].toInt(), it[1].toInt(), it[2].toInt()) }
            )
        )
            .isEqualTo(1598415)
    }

    @Test
    fun `given 2x3x4, then return 58`() {
        assertThat(
            wrappingPaperSquareFeet(
                sequenceOf(Triple(2, 3, 4))
            )
        )
            .isEqualTo(58)
    }

    @Test
    fun `given 1x1x10, then return 43`() {
        assertThat(
            wrappingPaperSquareFeet(
                sequenceOf(Triple(1, 1, 10))
            )
        )
            .isEqualTo(43)
    }
}