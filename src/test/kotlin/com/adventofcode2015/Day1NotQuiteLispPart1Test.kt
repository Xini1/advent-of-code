package com.adventofcode2015

import com.linesFromFile
import org.assertj.core.api.Assertions.assertThat
import kotlin.test.Test

/**
 * @author Maxim Tereshchenko
 */
internal class Day1NotQuiteLispPart1Test {

    @Test
    fun answer() {
        assertThat(
            floor(
                linesFromFile("2015/Day1NotQuiteLispInput")
                    .flatMap { it.asSequence() }
            )
        )
            .isEqualTo(280)
    }

    @Test
    fun `given (()), then return 0`() {
        assertThat(floor("(())".asSequence())).isEqualTo(0)
    }

    @Test
    fun `given ()(), then return 0`() {
        assertThat(floor("()()".asSequence())).isEqualTo(0)
    }

    @Test
    fun `given (((, then return 3`() {
        assertThat(floor("(((".asSequence())).isEqualTo(3)
    }

    @Test
    fun `given (()(()(, then return 3`() {
        assertThat(floor("(()(()(".asSequence())).isEqualTo(3)
    }

    @Test
    fun `given ))(((((, then return 3`() {
        assertThat(floor("))(((((".asSequence())).isEqualTo(3)
    }

    @Test
    fun `given ()), then return -1`() {
        assertThat(floor("())".asSequence())).isEqualTo(-1)
    }

    @Test
    fun `given ))(, then return -1`() {
        assertThat(floor("))(".asSequence())).isEqualTo(-1)
    }

    @Test
    fun `given ))), then return -3`() {
        assertThat(floor(")))".asSequence())).isEqualTo(-3)
    }

    @Test
    fun `given )())()), then return -3`() {
        assertThat(floor(")())())".asSequence())).isEqualTo(-3)
    }
}