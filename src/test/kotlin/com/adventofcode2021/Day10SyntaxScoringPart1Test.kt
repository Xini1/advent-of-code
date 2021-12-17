package com.adventofcode2021

import com.linesFromFile
import org.assertj.core.api.AssertionsForClassTypes.assertThat
import kotlin.test.Test

/**
 * @author Maxim Tereshchenko
 */
internal class Day10SyntaxScoringPart1Test {

    @Test
    fun answer() {
        assertThat(syntaxErrorScore(linesFromFile("2021/Day10SyntaxScoringInput"))).isEqualTo(216297)
    }

    @Test
    fun `given navigation subsystem, then return 26397`() {
        assertThat(
            syntaxErrorScore(
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
            .isEqualTo(26397)
    }
}