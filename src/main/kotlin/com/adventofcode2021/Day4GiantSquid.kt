package com.adventofcode2021

/**
 * @author Maxim Tereshchenko
 */
fun winningBoardFinalScore(draws: List<Int>, boardsRawInput: Sequence<List<List<Int>>>): Int {
    val boards = boardsRawInput.map { rawBoard ->
        Board(
            rawBoard.flatMapIndexed { row, rowList ->
                rowList.mapIndexed { column, value ->
                    Cell(row, column, value)
                }
            }
        )
    }

    for (draw in draws) {
        for (board in boards) {
            board.mark(draw)

            if (board.isWinning()) {
                return board.score(draw)
            }
        }
    }

    throw IllegalArgumentException()
}

private class Board(private val cells: List<Cell>) {

    fun mark(draw: Int) {
        cells.asSequence()
            .filter { it.hasValue(draw) }
            .firstOrNull()
            ?.mark()
    }

    fun isWinning(): Boolean {
        TODO("Not yet implemented")
    }

    fun score(draw: Int): Int {
        TODO("Not yet implemented")
    }
}

private class Cell(
    private val row: Int,
    private val column: Int,
    private val value: Int
) {
    var isMarked = false

    fun hasValue(draw: Int) = value == draw

    fun mark() {
        isMarked = true
    }
}