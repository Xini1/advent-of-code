package com.adventofcode2015

/**
 * @author Maxim Tereshchenko
 */
fun wrappingPaperSquareFeet(dimensions: Sequence<Triple<Int, Int, Int>>): Int {
    return dimensions.map { wrappingPaperSquareFeetForSingleBox(it.first, it.second, it.third) }
        .sum()
}

private fun wrappingPaperSquareFeetForSingleBox(length: Int, width: Int, height: Int): Int {
    val measurements = listOf(2 * length * width, 2 * width * height, 2 * height * length)
    return measurements.sum() + measurements.minOrNull()!! / 2
}