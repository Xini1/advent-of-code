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

fun countOutput(notes: Sequence<String>): Int {
    return notes.map { Note.from(it) }
        .onEach { it.configureWiring() }
        .map { it.signalValue() }
        .sum()
}

private class Note(private val digitOutputs: Set<String>, private val signals: Collection<String>) {

    private val wiringConfiguration = WiringConfiguration()

    companion object {

        fun from(noteString: String): Note {
            val outputsAndSignals = noteString.split(" | ")

            return Note(outputsAndSignals[0].split(' ').toSet(), outputsAndSignals[1].split(' '))
        }
    }

    fun configureWiring() {
        val outputs7 = digitOutputs.first { it.length == 3 }

        wiringConfiguration.configure(1, digitOutputs.first { it.length == 2 })
        wiringConfiguration.configure(4, digitOutputs.first { it.length == 4 })
        wiringConfiguration.configure(7, outputs7)
        wiringConfiguration.configure(
            3,
            digitOutputs.filter { it.length == 5 }
                .first { outputs -> outputs7.all { it in outputs } }
        )

        val configuredOutput2 = wiringConfiguration.configuredOutput(2)
        wiringConfiguration.configure(
            2,
            digitOutputs.filter { it.length == 5 }
                .first { outputs -> configuredOutput2.all { it in outputs } }
        )
    }

    fun signalValue() =
        signals.asSequence()
            .map { wiringConfiguration.digit(it) }
            .joinToString(separator = "")
            .toInt()
}

private class PossibleWiring(val input: Char) {

    private val possibleOutputs = "abcdefg".asSequence().toMutableSet()

    fun configure(inputs: String, outputs: String) {
        possibleOutputs.removeIf {
            if (input in inputs) {
                it !in outputs
            } else {
                it in outputs
            }
        }
    }

    fun takePartIn(inputs: String) = input in inputs

    fun isConfigured() = possibleOutputs.size == 1

    fun wire() = possibleOutputs.first().toString()

    fun isWiredTo(output: Char) = output in possibleOutputs

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as PossibleWiring

        if (input != other.input) return false

        return true
    }

    override fun hashCode(): Int {
        return input.hashCode()
    }

    override fun toString(): String {
        return "PossibleWiring(input=$input, possibleOutputs=$possibleOutputs)"
    }
}

private class WiringConfiguration {

    private val digitInputs = sequenceOf(
        0 to "abcefg",
        1 to "cf",
        2 to "acdeg",
        3 to "acdfg",
        4 to "bcdf",
        5 to "abdfg",
        6 to "abdefg",
        7 to "acf",
        8 to "abcdefg",
        9 to "abcdfg"
    )
        .toMap()

    private val possibleWirings = ('a'..'g').asSequence()
        .map { PossibleWiring(it) }
        .toSet()

    fun configure(digit: Int, outputs: String) {
        possibleWirings.forEach { it.configure(digitInputs[digit]!!, outputs) }
    }

    fun configuredOutput(digit: Int) =
        possibleWirings.asSequence()
            .filter { it.takePartIn(digitInputs[digit]!!) }
            .filter { it.isConfigured() }
            .joinToString(separator = "") { it.wire() }

    fun digit(outputs: String): Int {
        val configuredOutput = outputs.asSequence()
            .map {
                possibleWirings.first { possibleWiring -> possibleWiring.isWiredTo(it) }
            }
            .map { it.input }
            .sorted()
            .joinToString(separator = "")

        return digitInputs.asSequence()
            .filter { it.value == configuredOutput }
            .map { it.key }
            .first()
    }
}