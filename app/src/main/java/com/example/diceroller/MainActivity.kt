package com.example.diceroller

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.Int2
import android.widget.Button
import android.widget.ImageView
import kotlin.random.Random


class MainActivity : AppCompatActivity() {
    lateinit var dice_Image: ImageView
    lateinit var dice_Image2: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll_button)
        rollButton.setOnClickListener {
            rolldice()
        }
    }

    private fun rolldice() {
        val randomInt = Random.nextInt(6) + 1
        val randomInt2 = Random.nextInt(6) + 1
        val drawableResource = when (randomInt) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        val drawableResource2 = when (randomInt2) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6

        }


        dice_Image.setImageResource(drawableResource)

        dice_Image2.setImageResource(drawableResource2)

        match(randomInt, randomInt2)
    }

    private fun match(randomInt: Int, randomInt2: Int) {
        var a = 0
        repeat(1000) { rolldice() }
        if (randomInt == randomInt2) {
            a = a + 1
        }
        println("($a/1000)*100")
        println("$a")

    }


}
