package com.tenniskata.app.viewmodel

import androidx.lifecycle.ViewModel

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
        if (winsPlayerOne())
            return "Player one wins"
        else if (winsPlayerTwo())
            return "Player two wins"
        else if (deuce())
            return "Deuce"
        else if (playerOneAdvantage())
            return "Advantage player one"
        else if (playerTwoAdvantage())
            return "Advantage player two"
        else if (playerOneScore == playerTwoScore)
            return getScoreDescription(playerOneScore)
        else
            return getScoreDescription(playerOneScore) + " - " + getScoreDescription(playerTwoScore)
    }
}