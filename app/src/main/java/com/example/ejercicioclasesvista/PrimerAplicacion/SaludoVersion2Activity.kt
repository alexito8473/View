package com.example.ejercicioclasesvista.PrimerAplicacion

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import com.example.ejercicioclasesvista.R

class SaludoVersion2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_saludo_version2)
        val butEnviarDatos = findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.butPulsadorNombreVersion2)
        val nombreRecibido = findViewById<EditText>(R.id.editMiNombre)
        val tituloEnviarNomnre="nombreUsuario"
        butEnviarDatos.setOnClickListener {
            var nombre=nombreRecibido.text.toString().trim()
            if(nombre.isBlank()){
                navegartoSolutionV2_2(tituloEnviarNomnre,"No se ha introducido correctamente el nombre")
            }else{
                navegartoSolutionV2_2(tituloEnviarNomnre,nombre)
            }
        }
    }
    private fun navegartoSolutionV2_2(titulo:String, valor:String){
        val intentResultado = Intent(this,SaludoVersion2_2Activity::class.java)
        intentResultado.putExtra(titulo, valor)
        startActivity(intentResultado)
    }
}