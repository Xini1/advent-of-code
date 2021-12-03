package com.adventofcode2015

import com.linesFromFile
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

/**
 * @author Maxim Tereshchenko
 */
internal class Day1NotQuiteLispPart2Test {

    @Test
    fun answer() {
        assertThat(
            enterTheBasementPosition(
                linesFromFile("2015/NotQuiteLispInput")
                    .flatMap { it.asSequence() }
            )
        )
            .isEqualTo(1797)
    }

    @Test
    fun `given ), then return 1`() {
        assertThat(enterTheBasementPosition(")".asSequence())).isEqualTo(1)
    }

    @Test
    fun `given ()()), then return 5`() {
        assertThat(enterTheBasementPosition("()())".asSequence())).isEqualTo(5)
    }
}