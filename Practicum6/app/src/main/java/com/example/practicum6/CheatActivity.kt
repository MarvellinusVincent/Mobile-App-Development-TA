package com.example.practicum6

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practicum6.databinding.ActivityCheatBinding

private lateinit var binding: ActivityCheatBinding
private const val EXTRA_ANSWER_IS_TRUE = "com.example.practicum6.answer_is_true"
const val EXTRA_ANSWER_SHOWN = "com.example.practicum6.answer_shown"
private const val KEY_ANSWER_SHOWN = "com.example.practicum6.key_answer_shown"

private var answerIsTrue = false
private var answerShown = false

class CheatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheatBinding.inflate(layoutInflater)
        setContentView(binding.root)
        answerIsTrue = intent.getBooleanExtra(EXTRA_ANSWER_IS_TRUE, false)

        // challenge 2
        if (savedInstanceState != null) {
            answerShown = savedInstanceState.getBoolean(KEY_ANSWER_SHOWN, false)
            if (answerShown) {
                showAnswerText()
                setAnswerShownResult(true)
            }
        }


        binding.showAnswerButton.setOnClickListener {
            showAnswerText()
            setAnswerShownResult(true)
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean(KEY_ANSWER_SHOWN, answerShown)
    }

    // challenge 2
    private fun showAnswerText() {
        val answerText = when {
            answerIsTrue -> R.string.true_button
            else -> R.string.false_button
        }
        binding.answerTextView.setText(answerText)
        answerShown = true
    }

    private fun setAnswerShownResult(isAnswerShown: Boolean) {
        val data = Intent().apply {
            putExtra(EXTRA_ANSWER_SHOWN, isAnswerShown)
        }
        setResult(Activity.RESULT_OK, data)
    }

    companion object {
        fun newIntent(packageContext: Context, answerIsTrue: Boolean):
                Intent {
            return Intent(packageContext, CheatActivity::class.java).apply {
                putExtra(EXTRA_ANSWER_IS_TRUE, answerIsTrue)
            }
        }
    }
}