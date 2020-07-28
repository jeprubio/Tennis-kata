package com.tenniskata.app.viewmodel

import androidx.lifecycle.ViewModel
import java.lang.IllegalStateException

class GameViewModel : ViewModel() {
    internal var playerOneScore = 0
    internal var playerTwoScore = 0

    fun deuce() =
        playerOneScore >= 3 && playerTwoScore >= 3 && playerOneScore == playerTwoScore

    fun winsPlayerOne(): Boolean {
        return playerOneScore >= 4 && playerOneScore > playerTwoScore + 1
    }

    fun winsPlayerTwo(): Boolean {
        return playerTwoScore >= 4 && playerTwoScore > playerOneScore + 1
    }

    fun getScoreDescription(score: Int) = when (score) {
        1 -> "fifteen"
        2 -> "thirty"
        3 -> "forty"
        else -> "love"
    }

    fun playerOneAdvantage() = playerOneScore >= 3 && playerTwoScore >= 3
            && playerOneScore == playerTwoScore + 1

    fun playerTwoAdvantage() = playerOneScore >= 3 && playerTwoScore >= 3
            && playerOneScore + 1 == playerTwoScore

    fun hasWinner() = winsPlayerOne() || winsPlayerTwo()
    fun getScoreboard(): String {
        return "Player one wins"
        throw IllegalStateException("Unknown score")
    }
}