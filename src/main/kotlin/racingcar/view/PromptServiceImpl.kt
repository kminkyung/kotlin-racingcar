package racingcar.view

import racingcar.domain.car.CarName
import racingcar.domain.car.CarRacingResult
import racingcar.view.Message.RACING_CANDIDATE_NAME_INPUT
import racingcar.view.Message.RACING_MOVE_INPUT

class PromptServiceImpl(
    private val inputView: InputView,
    private val resultView: ResultView
) : PromptService {

    override fun getNameOfCars(assignedNames: String?): Set<String> {
        println(RACING_CANDIDATE_NAME_INPUT)

        val names = assignedNames ?: inputView.readInput()
        return names.split(",").map { it.trim() }.toSet()
    }

    override fun getNumberOfMoves(assignedNumber: Int?): Int {
        println(RACING_MOVE_INPUT)

        return assignedNumber ?: inputView.readInput().toInt()
    }

    override fun showResult(result: List<CarRacingResult>, winners: Set<CarName>) {
        resultView.show(result, winners)
    }
}
