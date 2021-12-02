package com

/**
 * @author Maxim Tereshchenko
 */
fun linesFromFile(name: String) =
    Thread.currentThread()
        .contextClassLoader
        .getResourceAsStream(name)!!
        .bufferedReader()
        .lineSequence()