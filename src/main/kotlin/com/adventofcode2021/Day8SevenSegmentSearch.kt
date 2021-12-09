package com.adventofcode2021

/**
 * @author Maxim Tereshchenko
 */
fun count1478InOutput(notes: Sequence<String>): Int {
    return notes.map { it.substringAfter("| ") }
        .flatMap { it.split(' ') }
        .map { it.length }
        .count { setOf(2, 3, 4, 7).contains(it) }
}