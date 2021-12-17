package com.adventofcode2021

import com.linesFromFile
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import kotlin.test.Test

/**
 * @author Maxim Tereshchenko
 */
internal class Day10SyntaxScoringPart2Test {

    @Test
    fun answer() {
        assertThat(middleCompletionScore(linesFromFile("2021/Day10SyntaxScoringInput"))).isEqualTo(2165057169)
    }

    @Test
    fun `given navigation subsystem, then return 288957`() {
        assertThat(
            middleCompletionScore(
                sequenceOf(
                    "[({(<(())[]>[[{[]{<()<>>",
                    "[(()[<>])]({[<{<<[]>>(",
                    "{([(<{}[<>[]}>{[]{[(<()>",
                    "(((({<>}<{<{<>}{[]{[]{}",
                    "[[<[([]))<([[{}[[()]]]",
                    "[{[{({}]{}}([{[{{{}}([]",
                    "{<[[]]>}<{[{[{[]{()[[[]",
                    "[<(<(<(<{}))><([]([]()",
                    "<{([([[(<>()){}]>(<<{{",
                    "<{([{{}}[<[[[<>{}]]]>[]]"
                )
            )
        )
            .isEqualTo(288957)
    }
}