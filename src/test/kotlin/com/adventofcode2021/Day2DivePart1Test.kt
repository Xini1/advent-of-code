package com.adventofcode2021

import com.linesFromFile
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

/**
 * @author Maxim Tereshchenko
 */
internal class Day2DivePart1Test {

    @Test
    fun answer() {
        assertThat(multiplyFinalHorizontalPositionByFinalDepth(linesFromFile("2021/DiveInput"), SimplePosition()))
            .isEqualTo(1484118)
    }

    @Test
    fun `given forward 1 down 1, then return 1`() {
        assertThat(
            multiplyFinalHorizontalPositionByFinalDepth(
                sequenceOf("forward 1", "down 1"),
                SimplePosition()
            )
        )
            .isEqualTo(1)
    }

    @Test
    fun `given forward 1 up 1, then return -1`() {
        assertThat(
            multiplyFinalHorizontalPositionByFinalDepth(
                sequenceOf("forward 1", "up 1"),
                SimplePosition()
            )
        )
            .isEqualTo(-1)
    }

    @Test
    fun `given up 1, then return 0`() {
        assertThat(multiplyFinalHorizontalPositionByFinalDepth(sequenceOf("up 1"), SimplePosition()))
            .isEqualTo(0)
    }

    @Test
    fun `given forward 5 down 5 forward 8 up 3 down 8 forward 2, then return 150`() {
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
                SimplePosition()
            )
        )
            .isEqualTo(150)
    }
}