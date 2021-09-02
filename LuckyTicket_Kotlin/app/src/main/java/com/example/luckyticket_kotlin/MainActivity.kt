package com.example.luckyticket_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity(), View.OnClickListener {
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.button)
        button.setOnClickListener(this)
    }

    override fun onClick(p0: View?) {
        val editText = findViewById<EditText>(R.id.editTextTextPersonName)
        val bulb = findViewById<ImageView>(R.id.lightbulb)
        val greenBulb = getDrawable(resources.getIdentifier("@drawable/ic_green_bulb", null, packageName))
        val redBulb = getDrawable(resources.getIdentifier("@drawable/ic_red_bulb", null, packageName))
        val number = editText.text.toString()

        if (number.length == 6) {
            if (number[0].code + number[1].code + number[2].code
                == number[3].code + number[4].code + number[5].code) {
                bulb.setImageDrawable(greenBulb)
                val toast = Toast.makeText(applicationContext, R.string.lucky_ticket, Toast.LENGTH_SHORT)
                toast.show()
            } else {
                bulb.setImageDrawable(redBulb)
                val toast = Toast.makeText(applicationContext, R.string.unlucky_ticket, Toast.LENGTH_SHORT)
                toast.show()
            }
        } else {
            val toast = Toast.makeText(applicationContext, R.string.incorrect_input, Toast.LENGTH_SHORT)
            toast.show()
        }
    }
}