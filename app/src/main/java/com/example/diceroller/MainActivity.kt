package com.example.diceroller

import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private var currentResult = -1

    companion object {
        private const val CURRENT_RESULT_KEY = "CURRENT_RESULT"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        savedInstanceState?.let {
            currentResult = it.getInt(CURRENT_RESULT_KEY)
            setProperDiceImage(currentResult)
        }
        viewBinding.buttonRole.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        currentResult = Random().nextInt(6) + 1
        setProperDiceImage(currentResult)
    }

    private fun setProperDiceImage(value: Int) {
        val properResource = when (value) {
            1 -> R.drawable.icon_main_dice_1
            2 -> R.drawable.icon_main_dice_2
            3 -> R.drawable.icon_main_dice_3
            4 -> R.drawable.icon_main_dice_4
            5 -> R.drawable.icon_main_dice_5
            6 -> R.drawable.icon_main_dice_6
            else -> R.drawable.icon_main_empty_dice
        }
        viewBinding.imageDice.setImageResource(properResource)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)

        outState.putInt(CURRENT_RESULT_KEY, currentResult)
    }
}