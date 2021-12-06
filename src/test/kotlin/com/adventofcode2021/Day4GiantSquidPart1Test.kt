package com.adventofcode2021

import com.linesFromFile
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

internal class Day4GiantSquidPart1Test {

    @Test
    fun answer() {
        val lines = linesFromFile("2021/Day4GiantSquidInput").toList()

        assertThat(
            winningBoardFinalScore(
                lines.first()
                    .split(',')
                    .map { it.toInt() },
                lines.asSequence()
                    .drop(1)
                    .filter { it.isNotBlank() }
                    .windowed(5, 5) { window ->
                        window.map { row ->
                            row.splitToSequence(' ')
                                .filter { it.isNotBlank() }
                                .map { it.toInt() }
                                .toList()
                        }
                    }
            )
        )
            .isEqualTo(89001)
    }

    @Test
    fun `given 3 boards, then return 4512`() {
        assertThat(
            winningBoardFinalScore(
                listOf(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24),
                sequenceOf(
                    listOf(
                        listOf(22, 13, 17, 11, 0),
                        listOf(8, 2, 23, 4, 24),
                        listOf(21, 9, 14, 16, 7),
                        listOf(6, 10, 3, 18, 5),
                        listOf(1, 12, 20, 15, 19)
                    ),
                    listOf(
                        listOf(3, 15, 0, 2, 22),
                        listOf(9, 18, 13, 17, 5),
                        listOf(19, 8, 7, 25, 23),
                        listOf(20, 11, 10, 24, 4),
                        listOf(14, 21, 16, 12, 6)
                    ),
                    listOf(
                        listOf(14, 21, 17, 24, 4),
                        listOf(10, 16, 15, 9, 19),
                        listOf(18, 8, 23, 26, 20),
                        listOf(22, 11, 13, 6, 5),
                        listOf(2, 0, 12, 3, 7)
                    )
                )
            )
        )
            .isEqualTo(4512)
    }
}