package com.adventofcode2021

/**
 * @author Maxim Tereshchenko
 */
fun lanternfishAfter80Days(fish: Sequence<Int>): Int {
    var fishPool = fish.map { Lanternfish(it) }
        .toList()

    repeat(80) {
        fishPool = fishPool.asSequence()
            .flatMap { it.dayAfter() }
            .toList()
    }

    return fishPool.size
}

fun lanternfishAfter256Days(fish: Sequence<Int>): Long {
    var fishMap = fish.groupingBy { it }
        .eachCount()
        .mapValues { (_, value) -> value.toLong() }

    repeat(256) {
        val nextFishMap = fishMap.toList()
            .asSequence()
            .filter { it.first != 0 }
            .map { it.first - 1 to it.second }
            .toMap(mutableMapOf())

        nextFishMap.compute(6) { _, current -> (current ?: 0) + (fishMap[0] ?: 0) }
        nextFishMap[8] = fishMap[0] ?: 0

        fishMap = nextFishMap
    }

    return fishMap.values.sum()
}

private class Lanternfish(private val timer: Int) {

    fun dayAfter() =
        if (timer == 0) {
            listOf(Lanternfish(6), Lanternfish(8))
        } else {
            listOf(Lanternfish(timer - 1))
        }
}