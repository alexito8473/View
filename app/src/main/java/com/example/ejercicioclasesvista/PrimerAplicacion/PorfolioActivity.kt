package com.example.ejercicioclasesvista.PrimerAplicacion

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.example.ejercicioclasesvista.R
import com.google.android.material.slider.RangeSlider

class PorfolioActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_porfolio)
        var butEnviar= findViewById<Button>(R.id.butPorfolioEnviar)
        butEnviar.setOnClickListener{
            val intentResultado = Intent(this,Porfolio2Activity::class.java)
            intentResultado.putExtra("porfolioEnviar", "Le has dado al botón")
            startActivity(intentResultado)
        }
    }
}