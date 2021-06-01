package com.example.f

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val foodButton: Button = findViewById(R.id.button)
        foodButton.setOnClickListener { changeFood() }
    }

    private fun changeFood() {
        //Create new dice instance with 6 sides
        val f = Food(9)
        val fChange = f.change()

        //Find the ImageView in the layout
        val foodImage: ImageView = findViewById(R.id.imageView)
        val foodText: TextView = findViewById(R.id.textView)

        //Determine which drawable resourceId to use based on the dice roll
        val drawableResource = when (fChange) {
            1 -> R.drawable.pip
            2 -> R.drawable.pizza_puff
            3 -> R.drawable.fries
            4 -> R.drawable.burger
            5 -> R.drawable.dcoke
            6 -> R.drawable.choco
            7 -> R.drawable.wsh
            8 -> R.drawable.nachos
            else -> R.drawable.chocochips
        }
        val text = when (fChange) {
            1 -> R.string.text1
            2 -> R.string.text2
            3 -> R.string.text3
            4 -> R.string.text4
            5 -> R.string.text5
            6 -> R.string.text6
            7 -> R.string.text7
            8 -> R.string.text8
            else -> R.string.text9
        }
        //Update the ImageView with the correct drawable resource ID
        foodImage.setImageResource(drawableResource)
        foodText.setText(text)
        //Update the content description
        foodImage.contentDescription  = fChange.toString()
    }
}

class Food(private val numDish: Int) {
    fun change(): Int {
        return (1..numDish).random()
    }
}