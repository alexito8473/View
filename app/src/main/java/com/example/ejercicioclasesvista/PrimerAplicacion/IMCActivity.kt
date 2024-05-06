package com.example.ejercicioclasesvista.PrimerAplicacion

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.cardview.widget.CardView
import com.example.ejercicioclasesvista.R
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class IMCActivity : AppCompatActivity() {

    private lateinit var butHombre: CardView
    private lateinit var butMujer: CardView
    private lateinit var rangeAltura: RangeSlider
    private lateinit var textAltura: TextView
    private lateinit var butPesoSuma: CardView
    private lateinit var butPesoRecta: CardView
    private lateinit var butEdadSuma: CardView
    private lateinit var butEdadRecta: CardView
    private lateinit var textPeso: TextView
    private lateinit var textEdad: TextView
    private lateinit var butCalcular: AppCompatButton
    private var isHombre: Boolean = false
    private var pesoMinimo: Int = 0
    private var pesoMaximo: Int = 0
    private var edadMinimo: Int = 0
    private var edadMaximo: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imcactivity)
        initVariables()
        initConstantes()
        initButon()
    }

    private fun initVariables() {
        butHombre = findViewById(R.id.butIMCIsHombre)
        butMujer = findViewById(R.id.butIMCIsMujer)
        rangeAltura = findViewById(R.id.sliderIMCrangoAltura)
        textAltura = findViewById(R.id.textIMCmostrarAltura)
        butPesoSuma = findViewById(R.id.butIMCPesoMas)
        butPesoRecta = findViewById(R.id.butIMCPesoMenos)
        butEdadSuma = findViewById(R.id.butIMCEdadMas)
        butEdadRecta = findViewById(R.id.butIMCEdadMenos)
        textPeso = findViewById(R.id.textIMCverPeso)
        textEdad = findViewById(R.id.textIMCverEdad)
        butCalcular= findViewById(R.id.butIMCcalcular)
    }

    private fun initButon() {
        butHombre.setOnClickListener { funcionBotonHombre() }
        butMujer.setOnClickListener { funcionBotonMujer() }
        rangeAltura.addOnChangeListener { _, value, _ ->
            textAltura.text = value.toInt().toString()
        }
        butPesoSuma.setOnClickListener { funcionSumar(textPeso, pesoMaximo) }
        butPesoRecta.setOnClickListener { funcionRectar(textPeso, pesoMinimo) }
        butEdadSuma.setOnClickListener { funcionSumar(textEdad, edadMaximo) }
        butEdadRecta.setOnClickListener { funcionRectar(textEdad, edadMinimo) }
        butCalcular.setOnClickListener { funcionCalcular() }
    }


    private fun initConstantes() {
        funcionBotonHombre()
        pesoMinimo = 0
        pesoMaximo = 120
        edadMinimo = 0
        edadMaximo = 120
    }

    private fun funcionCalcular(){
        Log.i("IMC!!", calcularIMC().toString())
    }
    private fun calcularIMC():Double{
        return textPeso.text.toString().toDouble()/((textAltura.text.toString().toDouble()/100)*(textAltura.text.toString().toDouble()/100))
    }
    private fun funcionSumar(textCambiante: TextView, limite: Int) {
        val miPeso = textCambiante.text.toString().toInt()
        if (miPeso != limite) {
            textCambiante.text = (miPeso + 1).toString();
        }
    }

    private fun funcionRectar(textCambiante: TextView, limite: Int) {
        val miPeso = textCambiante.text.toString().toInt()
        if (miPeso != limite) {
            textCambiante.text = (miPeso - 1).toString();
        }
    }

    @SuppressLint("ResourceAsColor")
    private fun funcionBotonHombre() {
        butHombre.setCardBackgroundColor(R.color.butonActivado)
        butMujer.setCardBackgroundColor(R.color.butNoActividado)
        isHombre = true
    }

    @SuppressLint("ResourceAsColor")
    private fun funcionBotonMujer() {
        butMujer.setCardBackgroundColor(R.color.butonActivado)
        butHombre.setCardBackgroundColor(R.color.butNoActividado)
        isHombre = false
    }
}