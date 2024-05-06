package com.example.ejercicioclasesvista.PrimerAplicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import com.example.ejercicioclasesvista.R

class SolutionActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_solution)
        val textNombre=findViewById<EditText>(R.id.editMiNombre);
        val pulsadorNombre=findViewById<androidx.appcompat.widget.AppCompatButton>(R.id.butPulsadorNombre)
        val textSalida=findViewById<TextView>(R.id.textVisualizarNombre);
        pulsadorNombre.setOnClickListener{
            val nombre=textNombre.text.toString();
            if(nombre.isBlank()){
                textSalida.setText("No has introducido ningun nombre");
                Log.i("NombreUsuario","Nombre vacio")
            }else{
                textSalida.setText("Buenos dias ${nombre.trim()}");
            }
        }
    }
}