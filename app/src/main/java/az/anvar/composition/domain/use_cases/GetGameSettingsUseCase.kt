package az.anvar.composition.domain.use_cases

import az.anvar.composition.domain.entity.GameSettings
import az.anvar.composition.domain.entity.Level
import az.anvar.composition.domain.repository.GameRepository

class GetGameSettingsUseCase(
    private val gameRepository: GameRepository
) {
    operator fun invoke(level: Level): GameSettings {
        return gameRepository.getGameSettings(level)
    }
}