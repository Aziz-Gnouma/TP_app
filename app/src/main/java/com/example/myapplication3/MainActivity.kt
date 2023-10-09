package com.example.myapplication3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var chkAndro: CheckBox
    private lateinit var chkMicro: CheckBox
    private lateinit var btnAffich: Button
    private lateinit var radSpecalityType: RadioGroup
    private lateinit var radDSI: RadioButton
    private lateinit var radRSI: RadioButton
    private lateinit var radSEM: RadioButton
    private lateinit var textView: TextView
    private var option1 = ""
    private var option2 = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        chkAndro = findViewById(R.id.chkAndro)
        chkMicro = findViewById(R.id.chkMicro)
        btnAffich = findViewById(R.id.btnAffich)
        radSpecalityType = findViewById(R.id.radSpecialityType)
        radDSI = findViewById(R.id.radDSI)
        radRSI = findViewById(R.id.radRSI)
        radSEM = findViewById(R.id.radSEM)
        textView = findViewById(R.id.Result)

        btnAffich.setOnClickListener {
            option1 = ""

            if (radDSI.isChecked) {
                option1 = radDSI.text.toString()
            } else if (radRSI.isChecked) {
                option1 = radRSI.text.toString()
            } else if (radSEM.isChecked) {
                option1 = radSEM.text.toString()
            }

            option2 = ""

            if (chkAndro.isChecked) {
                option2 += chkAndro.text
            }
            if (chkMicro.isChecked) {
                if (option2.isNotEmpty()) {
                    option2 += ", "
                }
                option2 += chkMicro.text
            }

            val result = if (option1.isNotEmpty() && option2.isNotEmpty()) {
                "Spécialité :$option1, type : $option2"
            } else if (option1.isNotEmpty()) {
                option1
            } else if (option2.isNotEmpty()) {
                option2
            } else {
                "Aucune option sélectionnée."
            }

            Toast.makeText(this, result, Toast.LENGTH_SHORT).show()
        }


    }

}