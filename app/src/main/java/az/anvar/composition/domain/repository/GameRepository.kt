package az.anvar.composition.domain.repository

import az.anvar.composition.domain.entity.GameSettings
import az.anvar.composition.domain.entity.Level
import az.anvar.composition.domain.entity.Question

interface GameRepository {

    fun generateQuestion(
        maxSamValue: Int,
        countOfOptions: Int
    ): Question

    fun getGameSettings(level: Level): GameSettings
}