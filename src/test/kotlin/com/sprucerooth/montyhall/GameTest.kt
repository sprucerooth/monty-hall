package com.sprucerooth.montyhall

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class GameTest {

    private lateinit var gameResult: GameResult

    @BeforeEach
    internal fun setUp() {
        val game = Game(10000)
        gameResult = game.start()
    }

    @Test
    fun winsArePopulated() {
        assert(gameResult.winsOnChosenBox > 0)
        assert(gameResult.winsOnRemainingBox > 0)
    }

    @Test
    fun moreWinsOnRemainingBox() {
        assert(gameResult.winsOnRemainingBox > gameResult.winsOnChosenBox)
    }
}