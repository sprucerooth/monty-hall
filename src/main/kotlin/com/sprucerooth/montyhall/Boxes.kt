package com.sprucerooth.montyhall

class Boxes(val boxList: List<Box>) {
    companion object {
        fun generate(): Boxes {
            val boxes = arrayListOf(Box("#1"), Box("#2"), Box("#3"))
            boxes.random().hasPrize = true
            return Boxes(boxes)
        }
    }

    fun chooseOne() {
        boxList.random().status = BoxStatus.CHOSEN
    }

    fun revealEmpty() {
        boxList.filterNot { b -> b.status == BoxStatus.CHOSEN }.filterNot(Box::hasPrize).first().status =
            BoxStatus.REVEALED_EMPTY
    }

    fun setRemaining() {
        boxList.filterNot { b -> b.status == BoxStatus.CHOSEN }
            .filterNot { b -> b.status == BoxStatus.REVEALED_EMPTY }
            .first().status = BoxStatus.REMAINING
    }
}