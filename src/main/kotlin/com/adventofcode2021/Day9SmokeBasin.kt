package com.adventofcode2021

fun lowPointsRisk(heightmap: List<List<Int>>): Int {
    val locationMatrix = heightmap.asSequence()
        .map {
            it.asSequence()
                .map { height -> Location(height) }
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
        .filter { it.isLowPoint() }
        .sumOf { it.riskLevel() }
}

private class Location(private val height: Int) {

    private val neighbours = mutableListOf<Location>()

    fun addNeighbour(location: Location) {
        neighbours += location
    }

    fun isLowPoint() = neighbours.all { it.height > height }

    fun riskLevel() = height + 1
}