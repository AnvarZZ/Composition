package az.anvar.composition.presentation

import android.content.Context
import android.content.res.ColorStateList
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import az.anvar.composition.R
import az.anvar.composition.domain.entity.GameResult

interface OnOptionClickListener {
    fun onOptionClick(option: Int)
}

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

@BindingAdapter("percentOfRightAnswers")
fun bindPercentOfRightAnswers(progressBar: ProgressBar, progress: Int) {
    progressBar.setProgress(progress, true)
}

@BindingAdapter("enoughRightAnswers")
fun bindEnoughRightAnswers(textView: TextView, isGood: Boolean) {
    textView.setTextColor(getColorByState(textView.context, isGood))
}

@BindingAdapter("enoughPercentOfRightAnswers")
fun bindEnoughPercentOfRightAnswers(progressBar: ProgressBar, isGood: Boolean) {
    val color = getColorByState(progressBar.context, isGood)
    progressBar.progressTintList = ColorStateList.valueOf(color)
}

private fun getColorByState(context: Context, goodState: Boolean): Int {
    val colorResId = if (goodState) {
        android.R.color.holo_green_light
    } else {
        android.R.color.holo_red_light
    }
    return ContextCompat.getColor(context, colorResId)
}

@BindingAdapter("numberAsText")
fun bindNumberAsText(textView: TextView, number: Int) {
    textView.text = number.toString()
}

@BindingAdapter("onOptionClickListener")
fun bindOnOptionClickListener(textView: TextView, clickListener: OnOptionClickListener) {
    textView.setOnClickListener {
        clickListener.onOptionClick(textView.text.toString().toInt())
    }
}