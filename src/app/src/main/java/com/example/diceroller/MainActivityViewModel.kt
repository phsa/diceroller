package com.example.diceroller

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.util.Random

class MainActivityViewModel: ViewModel() {

    private val diceResult = MutableLiveData(0)

    fun diceResult(): LiveData<Int> {
        return diceResult
    }

    fun rollDice() {
        diceResult.value = Random().nextInt(6) + 1
    }

}