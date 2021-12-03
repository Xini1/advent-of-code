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

fun enterTheBasementPosition(parentheses: Sequence<Char>): Int {
    val parenthesesList = parentheses.toList()
    var currentFloor = 0

    for (index in parenthesesList.indices) {
        when (parenthesesList[index]) {
            '(' -> currentFloor += 1
            ')' -> currentFloor -= 1
            else -> throw IllegalArgumentException()
        }

        if (currentFloor == -1) {
            return index + 1
        }
    }

    throw IllegalArgumentException()
}