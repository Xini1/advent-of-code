package com.adventofcode

/**
 * @author Maxim Tereshchenko
 */
fun multiplyFinalHorizontalPositionByFinalDepth(commands: Sequence<String>, startingPosition: Position): Int {
    return commands.map { it.split(" ") }
        .map { it[0] to it[1].toInt() }
        .map {
            when (it.first) {
                "forward" -> ForwardCommand(it.second)
                "down" -> DownCommand(it.second)
                "up" -> UpCommand(it.second)
                else -> throw IllegalArgumentException()
            }
        }
        .fold(startingPosition) { position, command -> command.execute(position) }
        .run { multiplyHorizontalPositionByDepth() }
}

interface Position {

    fun forwardBy(amount: Int): Position
    fun downBy(amount: Int): Position
    fun upBy(amount: Int): Position
    fun multiplyHorizontalPositionByDepth(): Int
}

abstract class BasePosition(protected val depth: Int, protected val horizontal: Int) : Position {

    override fun upBy(amount: Int) = downBy(-amount)
    override fun multiplyHorizontalPositionByDepth() = depth * horizontal
}

class SimplePosition(depth: Int = 0, horizontal: Int = 0) : BasePosition(depth, horizontal) {

    override fun forwardBy(amount: Int) = SimplePosition(depth, horizontal + amount)
    override fun downBy(amount: Int) = SimplePosition(depth + amount, horizontal)
}

class AdvancedPosition(
    depth: Int = 0,
    horizontal: Int = 0,
    private val aim: Int = 0
) : BasePosition(depth, horizontal) {

    override fun forwardBy(amount: Int) =
        AdvancedPosition(depth + aim * amount, horizontal + amount, aim)

    override fun downBy(amount: Int) = AdvancedPosition(depth, horizontal, aim + amount)
}

private abstract class SubmarineCommand(protected val amount: Int) {

    abstract fun execute(currentPosition: Position): Position
}

private class ForwardCommand(amount: Int) : SubmarineCommand(amount) {

    override fun execute(currentPosition: Position) = currentPosition.forwardBy(amount)
}

private class DownCommand(amount: Int) : SubmarineCommand(amount) {

    override fun execute(currentPosition: Position) = currentPosition.downBy(amount)
}

private class UpCommand(amount: Int) : SubmarineCommand(amount) {

    override fun execute(currentPosition: Position) = currentPosition.upBy(amount)
}

fun divePart1Answer() {
    println(multiplyFinalHorizontalPositionByFinalDepth(linesFromFile("DiveInput"), SimplePosition()))
}

fun divePart2Answer() {
    println(multiplyFinalHorizontalPositionByFinalDepth(linesFromFile("DiveInput"), AdvancedPosition()))
}

fun main() {
    divePart1Answer()
    divePart2Answer()
}