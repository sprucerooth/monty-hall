package com.sprucerooth.montyhall

class Game(private val rounds: Int) {

    fun start(): GameResult {
        val gameResult = GameResult()

        for (i in 1..rounds) {
            val roundResult = Round().play()
            if (roundResult.prizeInChosenBox) gameResult.winsOnChosenBox++
            else if (roundResult.prizeInRemainingBox) gameResult.winsOnRemainingBox++
        }
        return gameResult
    }
}