package com.adventofcode2021

/**
 * @author Maxim Tereshchenko
 */
fun measurementsLargerThanPreviousMeasurement(measurements: Sequence<Int>): Int {
    return measurements.zipWithNext()
        .count { it.second > it.first }
}

fun measurementsInWindowLargerThanInPreviousWindow(measurements: Sequence<Int>): Int {
    return measurements.zipWithNext()
        .zipWithNext { firstPair, secondPair -> Triple(firstPair.first, firstPair.second, secondPair.second) }
        .map { it.first + it.second + it.third }
        .zipWithNext()
        .count { it.second > it.first }
}