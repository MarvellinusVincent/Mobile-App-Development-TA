package com.example.practicum6

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

private const val TAG = "QuizViewModel"
const val CURRENT_INDEX_KEY = "CURRENT_INDEX_KEY"
const val ARE_BUTTONS_ENABLED_KEY = "ARE_BUTTONS_ENABLED_KEY"
const val IS_CHEATER_KEY = "IS_CHEATER_KEY"

class QuizViewModel(private val savedStateHandle: SavedStateHandle) : ViewModel() {

    private val questionBank = listOf(
        Question(R.string.question_australia, true),
        Question(R.string.question_oceans, true),
        Question(R.string.question_mideast, true),
        Question(R.string.question_africa, true),
        Question(R.string.question_americas, true),
        Question(R.string.question_asia, true)
    )

    var isCheater: Boolean
        get() = savedStateHandle.get(IS_CHEATER_KEY) ?: false
        set(value) = savedStateHandle.set(IS_CHEATER_KEY, value)

    private var currentIndex : Int
        get() = savedStateHandle.get(CURRENT_INDEX_KEY) ?: 0
        set(value) = savedStateHandle.set(CURRENT_INDEX_KEY, value)

    var areButtonsEnabled: Boolean
        get() = savedStateHandle.get(ARE_BUTTONS_ENABLED_KEY) ?: true
        set(value) = savedStateHandle.set(ARE_BUTTONS_ENABLED_KEY, value)

    val currentQuestionAnswer : Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText : Int
        get() = questionBank[currentIndex].textResID

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
        // challenge 3
        isCheater = false
        areButtonsEnabled = true
    }

    fun moveToPrevious() {
        currentIndex = (currentIndex - 1) % questionBank.size
        // challenge 3
        isCheater = false
        areButtonsEnabled = true
    }

}