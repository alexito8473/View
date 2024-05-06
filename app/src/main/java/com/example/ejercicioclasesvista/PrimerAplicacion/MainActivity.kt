package com.example.ejercicioclasesvista.PrimerAplicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.ejercicioclasesvista.R

class MainActivity : AppCompatActivity() {
    private lateinit var butBotones: CardView
    private lateinit var butSolution: CardView
    private lateinit var butSolution2: CardView
    private lateinit var butCalculadora: CardView
    private lateinit var butIMC: CardView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        iniciarVariables()
        controlBotones()
    }

    private fun iniciarVariables() {
        butBotones = findViewById(R.id.butIrBotones)
        butSolution = findViewById(R.id.butIrSolution)
        butSolution2 = findViewById(R.id.butIrSolutionV2)
        butCalculadora = findViewById(R.id.butIrCalculadora)
        butIMC = findViewById(R.id.butIrIMC)
    }

    private fun controlBotones() {
        butBotones.setOnClickListener { navegarIrBotones() }
        butSolution.setOnClickListener { navegarIrSolucion() }
        butSolution2.setOnClickListener { navegarIrSolucionV2() }
        butCalculadora.setOnClickListener { navegarIrCalculadora() }
        butIMC.setOnClickListener { navegarIrIMC() }
    }


    private fun navegarIrBotones() {
        startActivity(Intent(this, BotonesActivity::class.java))
    }

    private fun navegarIrSolucion() {
        startActivity(Intent(this, SolutionActivity::class.java))
    }

    private fun navegarIrSolucionV2() {
        startActivity(Intent(this, SaludoVersion2Activity::class.java))
    }

    private fun navegarIrCalculadora() {
        startActivity(Intent(this, CalculadoraActivity::class.java))
    }

    private fun navegarIrIMC() {
        startActivity(Intent(this, IMCActivity::class.java))
    }
}