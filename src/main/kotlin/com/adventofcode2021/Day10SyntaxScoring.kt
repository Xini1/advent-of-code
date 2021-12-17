package com.adventofcode2021

/**
 * @author Maxim Tereshchenko
 */
fun syntaxErrorScore(lines: Sequence<String>): Int {
    return lines.map { Chunks(it) }
        .sumOf { it.syntaxErrorScore() }
}

fun middleCompletionScore(lines: Sequence<String>): Long {
    val sortedScores = lines.map { Chunks(it) }
        .filterNot { it.isCorrupted() }
        .map { it.completionScore() }
        .sorted()
        .toList()

    return sortedScores[sortedScores.size / 2]
}

private class Chunks(private val line: String) {

    private val syntaxErrorScores = mapOf(
        ')' to 3,
        ']' to 57,
        '}' to 1197,
        '>' to 25137
    )

    private val completionScores = mapOf(
        ')' to 1,
        ']' to 2,
        '}' to 3,
        '>' to 4
    )

    fun isCorrupted() = syntaxErrorScore() != 0

    fun syntaxErrorScore(): Int {
        val stack = mutableListOf<Chunk>()

        for (bracket in line) {
            val chunk = Chunk.from(bracket)

            if (chunk == null) {
                if (stack.last().canBeClosed(bracket)) {
                    stack.removeLast()
                } else {
                    return syntaxErrorScores[bracket]!!
                }
            } else {
                stack += chunk
            }
        }

        return 0
    }

    fun completionScore(): Long {
        val stack = mutableListOf<Chunk>()

        for (bracket in line) {
            val chunk = Chunk.from(bracket)

            if (chunk == null) {
                stack.removeLast()
            } else {
                stack += chunk
            }
        }

        return stack.reversed()
            .asSequence()
            .map { it.close }
            .mapNotNull { completionScores[it] }
            .fold(0L) { acc, next -> acc * 5 + next }
    }
}

private enum class Chunk(private val open: Char, val close: Char) {

    PARENTHESES('(', ')'),
    SQUARE('[', ']'),
    CURLY('{', '}'),
    ANGLE('<', '>');

    companion object {

        fun from(open: Char) =
            values()
                .asSequence()
                .firstOrNull { it.open == open }
    }

    fun canBeClosed(bracket: Char) = close == bracket
}

