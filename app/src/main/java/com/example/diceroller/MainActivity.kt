package com.example.diceroller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        viewModel.diceResult().observe(this, { result ->
            setProperDiceImage(result)
        })

        viewBinding.buttonRoll.setOnClickListener { viewModel.rollDice() }
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
}