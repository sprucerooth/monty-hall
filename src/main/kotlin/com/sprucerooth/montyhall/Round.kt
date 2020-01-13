package com.sprucerooth.montyhall

class Round {
    fun play(): RoundResult {
        val boxes = Boxes.generate()
        boxes.chooseOne()
        boxes.revealEmpty()
        boxes.setRemaining()

        val chosenBox = boxes.boxList.first { b -> b.status == BoxStatus.CHOSEN }
        val remainingBox = boxes.boxList.first { b -> b.status == BoxStatus.REMAINING }

        return RoundResult(chosenBox.hasPrize, remainingBox.hasPrize)
    }
}
