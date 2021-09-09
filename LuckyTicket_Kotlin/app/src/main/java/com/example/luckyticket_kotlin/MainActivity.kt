package com.example.luckyticket_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val MAX_NUMBER_OF_DIGITS = 6

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button : Button = findViewById(R.id.btnCheckNumber)
        button.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val editText = findViewById<EditText>(R.id.etTicketNumber)
        val bulb = findViewById<ImageView>(R.id.lightbulbImage)
        val greenBulb = getDrawable(R.drawable.ic_green_bulb)!!
        val redBulb = getDrawable(R.drawable.ic_red_bulb)!!
        val number = editText.text.toString()

        if (number.length == MAX_NUMBER_OF_DIGITS) {
            if (number[0].digitToInt() + number[1].digitToInt() + number[2].digitToInt()
                == number[3].digitToInt() + number[4].digitToInt() + number[5].digitToInt()) {
                bulb.setImageDrawable(greenBulb)
                Toast.makeText(applicationContext, R.string.lucky_ticket, Toast.LENGTH_SHORT).show()
            } else {
                bulb.setImageDrawable(redBulb)
                Toast.makeText(applicationContext, R.string.unlucky_ticket, Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(applicationContext, R.string.incorrect_input, Toast.LENGTH_SHORT).show()
        }
    }
}