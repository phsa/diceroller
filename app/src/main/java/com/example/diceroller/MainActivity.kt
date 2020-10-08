package com.example.diceroller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.diceroller.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
        viewBinding.buttonRole.setOnClickListener { rollDice() }
    }

    private fun rollDice() {
        val properResource = when ((Random().nextInt(6) + 1)) {
            1 -> R.drawable.icon_main_dice_1
            2 -> R.drawable.icon_main_dice_2
            3 -> R.drawable.icon_main_dice_3
            4 -> R.drawable.icon_main_dice_4
            5 -> R.drawable.icon_main_dice_5
            else -> R.drawable.icon_main_dice_6
        }
        viewBinding.imageDice.setImageResource(properResource)
    }
}