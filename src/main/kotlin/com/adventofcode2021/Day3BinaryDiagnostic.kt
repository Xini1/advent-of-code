package com.adventofcode2021

/**
 * @author Maxim Tereshchenko
 */
fun powerConsumption(binaryInput: Sequence<String>): Int {
    val mostCommonBits = binaryInput.flatMap {
        it.asSequence()
            .mapIndexed { index, char -> index to char.digitToInt() }
    }
        .fold(BinaryStatistics()) { statistics, (position, bit) -> statistics.adjust(position, bit) }
        .mostCommonBits()

    return mostCommonBits.toInt(2) * mostCommonBits.invertBits().toInt(2)
}

fun lifeSupport(binaryInput: Sequence<String>): Int {
    val oxygenGeneratorRating = numbersWithMostCommonBitInPosition(
        binaryInput,
        0,
        '0',
        '1'
    )

    val co2ScrubberRating = numbersWithMostCommonBitInPosition(
        binaryInput,
        0,
        '1',
        '0'
    )

    return oxygenGeneratorRating.toInt(2) * co2ScrubberRating.toInt(2)
}

fun numbersWithMostCommonBitInPosition(
    binaryInput: Sequence<String>,
    position: Int,
    bitIfMostCommonBitZero: Char,
    otherBit: Char
): String {
    val total = binaryInput.count()

    if (total == 1) {
        return binaryInput.first()
    }

    val zeroBits = binaryInput.map { it[position] }
        .count { it == '0' }

    return numbersWithMostCommonBitInPosition(
        binaryInput.filter { it[position] == if (zeroBits * 2 > total) bitIfMostCommonBitZero else otherBit },
        position + 1,
        bitIfMostCommonBitZero,
        otherBit
    )
}

private fun String.invertBits() =
    asSequence()
        .map {
            when (it) {
                '0' -> '1'
                '1' -> '0'
                else -> throw IllegalArgumentException()
            }
        }
        .joinToString(separator = "")

private class BinaryStatistics(private val positionToBitsMap: Map<Int, List<Int>> = emptyMap()) {

    fun adjust(position: Int, bit: Int) =
        BinaryStatistics(
            positionToBitsMap + (position to (positionToBitsMap[position] ?: emptyList()) + bit)
        )

    fun mostCommonBits() =
        positionToBitsMap.toList()
            .asSequence()
            .sortedBy { it.first }
            .map { it.second }
            .map { it.mostCommonBit() }
            .fold(StringBuilder()) { builder, bit -> builder.append(bit) }
            .toString()

    private fun List<Int>.mostCommonBit() =
        if (count { it == 0 } > size / 2) {
            0
        } else {
            1
        }
}