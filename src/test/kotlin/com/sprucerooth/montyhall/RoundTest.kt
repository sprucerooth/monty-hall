package com.sprucerooth.montyhall

import org.junit.jupiter.api.Test
import kotlin.test.assertNotSame

class RoundTest {

    @Test
    fun onlyOneBoxHasPrice() {
        val result = Round().play()
        assertNotSame(result.prizeInChosenBox, result.prizeInRemainingBox)
    }
}