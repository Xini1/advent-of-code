package com.adventofcode2021

/**
 * @author Maxim Tereshchenko
 */
fun lanternfishAfter80Days(fish: Sequence<Int>): Int {
    var fishPool = fish.map { Lanternfish(it) }
        .toList()

    for (i in 1..80) {
        fishPool = fishPool.asSequence()
            .flatMap { it.dayAfter() }
            .toList()
    }

    return fishPool.size
}

private class Lanternfish(private val timer: Int) {

    fun dayAfter() =
        if (timer == 0) {
            listOf(Lanternfish(6), Lanternfish(8))
        } else {
            listOf(Lanternfish(timer - 1))
        }
}