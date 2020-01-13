package com.sprucerooth.montyhall

class Box(val name: String, var hasPrize: Boolean = false, var status: BoxStatus = BoxStatus.UNASSIGNED)

enum class BoxStatus {
    UNASSIGNED, CHOSEN, REVEALED_EMPTY, REMAINING
}