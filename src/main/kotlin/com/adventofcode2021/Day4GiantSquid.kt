package com.adventofcode2021

/**
 * @author Maxim Tereshchenko
 */
fun firstWinningBoardScore(draws: List<Int>, boardsRawInput: Sequence<List<List<Int>>>): Int {
    val boards = boards(boardsRawInput)

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

fun lastWinningBoardScore(draws: List<Int>, boardsRawInput: Sequence<List<List<Int>>>): Int {
    var boards = boards(boardsRawInput)

    for (draw in draws) {
        boards.forEach { it.mark(draw) }

        if (boards.size == 1 && boards.first().isWinning()) {
            return boards.first().score(draw)
        }

        boards = boards.filterNot { it.isWinning() }
    }

    throw IllegalArgumentException()
}

private fun boards(boardsRawInput: Sequence<List<List<Int>>>) =
    boardsRawInput.mapIndexed { index, rawBoard ->
        Board(
            index + 1,
            rawBoard.flatMapIndexed { row, rowList ->
                rowList.mapIndexed { column, value ->
                    Cell(row, column, value)
                }
            }
        )
    }
        .toList()

private class Board(val number: Int, private val cells: List<Cell>) {

    fun mark(draw: Int) {
        cells.asSequence()
            .filter { it.hasValue(draw) }
            .firstOrNull()
            ?.mark()
    }

    fun isWinning(): Boolean {
        for (i in 0 until 5) {
            if (isColumnMarked(i) || isRowMarked(i)) {
                return true
            }
        }

        return false
    }

    fun score(draw: Int) =
        cells.asSequence()
            .filterNot { it.isMarked }
            .map { it.value }
            .sum() * draw

    private fun isRowMarked(row: Int) =
        cells.asSequence()
            .filter { it.isInRow(row) }
            .all { it.isMarked }


    private fun isColumnMarked(column: Int) =
        cells.asSequence()
            .filter { it.isInColumn(column) }
            .all { it.isMarked }

    override fun toString(): String {
        val builder = StringBuilder()

        builder.append(number)
            .append('\n')

        for (row in 0 until 5) {
            val cellsInRow = cells.filter { it.isInRow(row) }

            for (column in 0 until 5) {
                builder.append(String.format("%2d", cellsInRow.first { it.isInColumn(column) }.value))
                    .append(' ')
            }

            builder.append('\n')
        }

        return builder.toString()
    }
}

private class Cell(
    private val row: Int,
    private val column: Int,
    val value: Int
) {
    var isMarked = false

    fun hasValue(draw: Int) = value == draw

    fun mark() {
        isMarked = true
    }

    fun isInRow(row: Int) = this.row == row

    fun isInColumn(column: Int) = this.column == column

    override fun toString(): String {
        return "$value" + if (isMarked) "*" else ""
    }
}