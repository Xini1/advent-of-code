package com.adventofcode2021

import com.linesFromFile
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

/**
 * @author Maxim Tereshchenko
 */
internal class Day2DivePart2Test {

    @Test
    fun answer() {
        assertThat(
            multiplyFinalHorizontalPositionByFinalDepth(linesFromFile("2021/Day2DiveInput"), AdvancedPosition())
        )
            .isEqualTo(1463827010)
    }

    @Test
    fun `given forward 5 down 5 forward 8 up 3 down 8 forward 2, then return 900`() {
        assertThat(
            multiplyFinalHorizontalPositionByFinalDepth(
                sequenceOf(
                    "forward 5",
                    "down 5",
                    "forward 8",
                    "up 3",
                    "down 8",
                    "forward 2"
                ),
                AdvancedPosition()
            )
        )
            .isEqualTo(900)
    }
}