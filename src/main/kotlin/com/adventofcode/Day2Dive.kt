package com.adventofcode

/**
 * @author Maxim Tereshchenko
 */
fun multiplyFinalHorizontalPositionByFinalDepth(commands: Sequence<String>): Int {
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
        .fold(Position()) { position, command -> command.execute(position) }
        .run { multiplyHorizontalPositionByDepth() }
}

private data class Position(private val depth: Int = 0, private val horizontal: Int = 0) {

    fun forwardBy(amount: Int) = copy(horizontal = horizontal + amount)
    fun downBy(amount: Int) = copy(depth = depth + amount)
    fun upBy(amount: Int) = downBy(-amount)
    fun multiplyHorizontalPositionByDepth() = depth * horizontal
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
    println(multiplyFinalHorizontalPositionByFinalDepth(linesFromFile("DiveInput")))
}

fun main() {
    divePart1Answer()
}