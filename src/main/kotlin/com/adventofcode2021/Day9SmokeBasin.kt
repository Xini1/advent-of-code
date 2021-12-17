package com.adventofcode2021

fun lowPointsRisk(heightmap: List<List<Int>>): Int {
    return locations(heightmap).asSequence()
        .filter { it.isLowPoint() }
        .sumOf { it.riskLevel() }
}

fun basinSizesMultiplied(heightmap: List<List<Int>>): Int {
    return locations(heightmap).asSequence()
        .filter { it.isLowPoint() }
        .map { it.basinSize() }
        .sortedDescending()
        .take(3)
        .reduce { first, second -> first * second }
}


private fun locations(heightmap: List<List<Int>>): Collection<Location> {
    val locationMatrix = heightmap.asSequence()
        .mapIndexed { row, heights ->
            heights.asSequence()
                .mapIndexed { column, height -> Location(row, column, height) }
                .toList()
        }
        .toList()

    locationMatrix.forEach {
        it.asSequence()
            .zipWithNext()
            .forEach { (first, second) ->
                first.addNeighbour(second)
                second.addNeighbour(first)
            }
    }

    locationMatrix.asSequence()
        .zipWithNext()
        .forEach { (row1, row2) ->
            row1.asSequence()
                .zip(row2.asSequence())
                .forEach { (first, second) ->
                    first.addNeighbour(second)
                    second.addNeighbour(first)
                }
        }

    return locationMatrix.asSequence()
        .flatten()
        .toList()
}

private class Location(private val row: Int, private val column: Int, private val height: Int) {

    private val neighbours = mutableListOf<Location>()

    fun addNeighbour(location: Location) {
        neighbours += location
    }

    fun isLowPoint() = neighbours.all { it.height > height }

    fun riskLevel() = height + 1

    fun basinSize() = neighboursAscending(mutableSetOf(this))

    private fun neighboursAscending(collectedNeighbours: MutableSet<Location>): Int {
        neighbours.asSequence()
            .filter { it.height < 9 }
            .filter { collectedNeighbours.add(it) }
            .forEach { it.neighboursAscending(collectedNeighbours) }

        return collectedNeighbours.size
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Location

        if (row != other.row) return false
        if (column != other.column) return false

        return true
    }

    override fun hashCode(): Int {
        var result = row
        result = 31 * result + column
        return result
    }

    override fun toString(): String {
        return "Location(row=$row, column=$column, height=$height)"
    }
}