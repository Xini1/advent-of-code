package com.adventofcode2021

import kotlin.math.abs

/**
 * @author Maxim Tereshchenko
 */
fun leastFuelToAlignWithConstantBurnRate(positions: List<Int>) = leastFuelToAlign(positions) { 1 }

fun leastFuelToAlignWithIncreasingBurnRate(positions: List<Int>) = leastFuelToAlign(positions) { it }

private fun leastFuelToAlign(positions: List<Int>, fuelBurnRate: (Int) -> Int): Int {
    val crabSubmarines = positions.map { CrabSubmarine(it, fuelBurnRate) }

    return (positions.minOrNull()!!..positions.maxOrNull()!!)
        .asSequence()
        .map { targetPosition -> crabSubmarines.sumOf { it.fuelForMovingTo(targetPosition) } }
        .minOrNull()!!
}

private class CrabSubmarine(private val position: Int, private val fuelBurnRate: (Int) -> Int) {

    fun fuelForMovingTo(targetPosition: Int) =
        (1..abs(position - targetPosition))
            .sumOf { fuelBurnRate(it) }
}