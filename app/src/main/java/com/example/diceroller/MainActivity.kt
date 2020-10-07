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
        val result = (Random().nextInt(6) + 1)
        viewBinding.textResult.text = result.toString()
    }
}