package com.example.ejercicioclasesvista.PrimerAplicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.ejercicioclasesvista.R

class SaludoVersion2_2Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saludo_version22)
        val textoMostrar=findViewById<TextView>(R.id.textSolutionV2_2)
        val textoRecibido = intent.extras?.getString("nombreUsuario").orEmpty()
        val butVolver = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.butSaludoVersion2_2)
        butVolver.setOnClickListener { navegarVolver() }
        if(textoRecibido.isBlank()){
            textoMostrar.setText("$textoRecibido")
        }else{
            textoMostrar.setText("Hola $textoRecibido")
        }
    }

    private fun navegarVolver() {
        startActivity(Intent(this, SaludoVersion2Activity::class.java))
    }
}