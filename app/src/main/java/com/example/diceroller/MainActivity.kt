package com.example.diceroller

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.diceroller.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private val diceImageResources = hashMapOf(
        Pair(1, R.drawable.icon_main_dice_1),
        Pair(2, R.drawable.icon_main_dice_2),
        Pair(3, R.drawable.icon_main_dice_3),
        Pair(4, R.drawable.icon_main_dice_4),
        Pair(5, R.drawable.icon_main_dice_5),
        Pair(6, R.drawable.icon_main_dice_6)
    )

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
        val properResource = diceImageResources[value]
        viewBinding.imageDice.setImageResource(properResource?: R.drawable.icon_main_empty_dice)
    }
}