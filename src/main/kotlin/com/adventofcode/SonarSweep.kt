package com.adventofcode

/**
 * @author Maxim Tereshchenko
 */
fun measurementsLargerThanPreviousMeasurement(measurements: Sequence<Int>): Int {
    return measurements.zipWithNext()
        .count { it.second > it.first }
}

fun main() {
    println(
        measurementsLargerThanPreviousMeasurement(
            Thread.currentThread()
                .contextClassLoader
                .getResourceAsStream("SonarSweepInput")!!
                .bufferedReader()
                .lineSequence()
                .map { it.toInt() }
        )
    )
}