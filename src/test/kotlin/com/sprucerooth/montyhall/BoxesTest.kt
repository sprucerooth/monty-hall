package com.sprucerooth.montyhall

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class BoxesTest {

    private lateinit var boxes: Boxes

    @BeforeEach
    fun setUp() {
        boxes = Boxes.generate()
    }

    @Test
    fun boxListSizeIsThree() {
        assert(boxes.boxList.size == 3)
    }

    @Test
    fun onlyOneHasPriceOnGenerate() {
        var boxesWithPrices: Int = 0;
        boxes.boxList.forEach { b -> if (b.hasPrize) boxesWithPrices++ }

        assert(boxesWithPrices == 1)
    }

    @Test
    fun chosenStatusIsSetOnlyOnOneBox() {
        boxes.chooseOne()
        assertTrue(boxes.boxList.singleOrNull { b -> b.status == BoxStatus.CHOSEN } != null)
    }

    @Test
    fun revealedStatusIsSetAndHasNoPrize() {
        boxes.chooseOne()
        boxes.revealEmpty()

        assertTrue(boxes.boxList.singleOrNull { b -> b.status == BoxStatus.REVEALED_EMPTY } != null)
        assertFalse(boxes.boxList.first { b -> b.status == BoxStatus.REVEALED_EMPTY }.hasPrize)
    }

    @Test
    fun remainingStatusIsSet() {
        boxes.chooseOne()
        boxes.revealEmpty()
        boxes.setRemaining()
        assertTrue(boxes.boxList.singleOrNull { b -> b.status == BoxStatus.REMAINING } != null)
    }

    @Test
    fun playedBoxesHaveUniqueStatuses() {
        boxes.chooseOne()
        boxes.revealEmpty()
        boxes.setRemaining()
        val statuses = boxes.boxList.map { b -> b.status }
        assertTrue(statuses.any { b -> b == BoxStatus.CHOSEN })
        assertTrue(statuses.any { b -> b == BoxStatus.REVEALED_EMPTY })
        assertTrue(statuses.any { b -> b == BoxStatus.REMAINING })
    }
}
