package com.sprucerooth.montyhall

fun main(args: Array<String>) {
    if (args.isEmpty()) {
        println("You must provide number of rounds as an argument.")
        return
    }
    var rounds = 0;
    try {
        rounds = args[0].toInt()
    } catch (e: NumberFormatException) {
        println("Please provide a valid number.")
        return
    }

    val gameResult = Game(rounds).start()

    println("${gameResult.winsOnChosenBox} wins when sticking with the first choice.")
    println("${gameResult.winsOnRemainingBox} wins when choosing another box.")
}