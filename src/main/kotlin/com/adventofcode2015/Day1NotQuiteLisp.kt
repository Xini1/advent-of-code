package com.adventofcode2015

/**
 * @author Maxim Tereshchenko
 */
fun floor(parentheses: Sequence<Char>): Int {
    return parentheses.fold(0) { currentFloor, parenthesis ->
        when (parenthesis) {
            '(' -> currentFloor + 1
            ')' -> currentFloor - 1
            else -> currentFloor
        }
    }
}