package com.example.ejercicioclasesvista.PrimerAplicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.ejercicioclasesvista.R

class BotonesActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_botones)
        val boton1=findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.butPulsador1);
        val boton2=findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.butPulsador2);
        val texto=findViewById<TextView>(R.id.textVisual);
        boton1.setOnClickListener{
            texto.setText("Este el boton1");
        }
        boton2.setOnClickListener{
            texto.setText("Este el boton2");
        }
    }
}