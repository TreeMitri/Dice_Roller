package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

/**
 * This activity allows the user to roll a 6 sided die and displays the result to the screen
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener { rollDice() }

        //Initial Roll so the screen loads with an image.
        rollDice()
    }

    /**
     * Creates and rolls the dice, then updates the screen with the result
     */
    private fun rollDice() {
        //Create a new Die
        val diceImage: ImageView = findViewById(R.id.Dice6)
        val myDice6 = Dice(6)
        val diceRoll = myDice6.roll()

        //Update the dice image based on the value rolled.
        val newDice = when(diceRoll){
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        //Set the new image
        diceImage.setImageResource(newDice)

        //Update the Image Description
        diceImage.contentDescription = diceRoll.toString()

    }
}

class Dice(private val numSides: Int) {
    //Creates a die with the given amount of sides
    private val sides = numSides

    //Generates a random number between 1 and the amt of sides as a "roll"
    fun roll(): Int { return (1..sides).random() }
}

