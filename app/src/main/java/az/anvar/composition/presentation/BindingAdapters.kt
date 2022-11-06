package az.anvar.composition.presentation

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import az.anvar.composition.R
import az.anvar.composition.domain.entity.GameResult

@BindingAdapter("requiredAnswers")
fun bindRequiredAnswers(textView: TextView, count: Int) {
    textView.text = String.format(textView.context.getString(R.string.required_score), count)
}

@BindingAdapter("countOfRightAnswers")
fun bindCountOfRightAnswers(textView: TextView, count: Int) {
    textView.text = String.format(textView.context.getString(R.string.score_answers), count)
}

@BindingAdapter("requiredPercent")
fun bindRequiredPercent(textView: TextView, count: Int) {
    textView.text = String.format(textView.context.getString(R.string.required_percentage), count)
}

@BindingAdapter("scorePercentage")
fun bindScorePercentage(textView: TextView, gameResult: GameResult) {
    val scorePercent = if (gameResult.countOfQuestions == 0) {
        0
    } else {
        ((gameResult.countOfRightAnswers / gameResult.countOfQuestions.toDouble()) * 100).toInt()
    }
    textView.text =
        String.format(textView.context.getString(R.string.score_percentage), scorePercent)
}

@BindingAdapter("emojiSrc")
fun bindEmojiSrc(imageView: ImageView, isWinner: Boolean) {
    val drawableId = if (isWinner) {
        R.drawable.ic_smile
    } else {
        R.drawable.ic_sad
    }
    imageView.setImageResource(drawableId)

}