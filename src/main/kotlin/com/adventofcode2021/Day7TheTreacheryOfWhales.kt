package com.adventofcode2021

import kotlin.math.abs

/**
 * @author Maxim Tereshchenko
 */
fun leastFuelToAlign(positions: List<Int>): Int {
    return (positions.minOrNull()!!..positions.maxOrNull()!!)
        .asSequence()
        .map { targetPosition -> positions.sumOf { abs(it - targetPosition) } }
        .minOrNull()!!
}