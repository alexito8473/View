package com.example.ejercicioclasesvista.PrimerAplicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.ejercicioclasesvista.R
import org.w3c.dom.Text

class Porfolio2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_porfolio2)
        val textVisualizar = findViewById<TextView>(R.id.textPorfolio2Visualizar)
        val butPulsar = findViewById<Button>(R.id.butPorfolio2Devuelta)
        val textRecibido = intent.extras?.getString("porfolioEnviar").orEmpty()

        textVisualizar.text = textRecibido
        butPulsar.setOnClickListener {
            startActivity(Intent(this,PorfolioActivity::class.java))
        }
    }
}