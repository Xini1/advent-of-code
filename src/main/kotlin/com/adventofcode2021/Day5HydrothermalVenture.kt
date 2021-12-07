package com.adventofcode2021

import kotlin.math.max


/**
 * @author Maxim Tereshchenko
 */
fun horizontalOrVerticalLinesOverlappingPoints(lines: Sequence<String>) =
    overlappingPoints(lines) { it.isHorizontalOrVertical() }

fun linesOverlappingPoints(lines: Sequence<String>) = overlappingPoints(lines) { true }

private fun overlappingPoints(lines: Sequence<String>, ventLineFilter: (VentLine) -> Boolean): Int {
    val ventLines = lines.map { VentLine.from(it) }
        .filter(ventLineFilter)
        .toList()

    val ventField = VentField(
        ventLines.asSequence()
            .map { it.maxRow() }
            .maxOrNull()!! + 1,
        ventLines.asSequence()
            .map { it.maxColumn() }
            .maxOrNull()!! + 1
    )

    ventLines.forEach { ventField.write(it) }

    return ventField.dangerousPoints()
}

private class VentLine(private val start: Coordinates, private val end: Coordinates) {

    companion object {

        fun from(raw: String): VentLine {
            val startAndEnd = raw.split(" -> ")

            return VentLine(Coordinates.from(startAndEnd.first()), Coordinates.from(startAndEnd.last()))
        }
    }

    fun maxRow() = max(start.row, end.row)

    fun maxColumn() = max(start.column, end.column)

    fun isHorizontalOrVertical() = start.isLinedUp(end)

    fun coordinates(): Set<Coordinates> {
        val vector = start.vector(end)

        return (sequenceUntilEnd(vector) + sequenceOf(end))
            .toSet()
    }

    private fun sequenceUntilEnd(vector: Pair<Int, Int>) =
        generateSequence(start) { Coordinates(it.row + vector.first, it.column + vector.second) }
            .takeWhile { it != end }
}

private data class Coordinates(val row: Int, val column: Int) {

    companion object {

        fun from(raw: String): Coordinates {
            val columnAndRow = raw.split(',')
                .map { it.toInt() }

            return Coordinates(columnAndRow.last(), columnAndRow.first())
        }
    }

    fun vector(other: Coordinates) = vector(row, other.row) to vector(column, other.column)

    private fun vector(start: Int, end: Int) =
        when {
            start > end -> -1
            start < end -> 1
            else -> 0
        }

    fun isLinedUp(other: Coordinates) = row == other.row || column == other.column
}

private class VentField(rows: Int, columns: Int) {

    private val grid = Array(rows) { IntArray(columns) }

    fun write(ventLine: VentLine) {
        ventLine.coordinates()
            .forEach { (row, column) ->
                grid[row][column] = grid[row][column] + 1
            }
    }

    fun dangerousPoints() =
        grid.asSequence()
            .flatMap { it.asSequence() }
            .count { it >= 2 }
}