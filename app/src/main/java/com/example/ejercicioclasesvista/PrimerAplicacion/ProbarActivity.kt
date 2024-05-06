package com.example.ejercicioclasesvista.PrimerAplicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import com.example.ejercicioclasesvista.R

class ProbarActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_probar)
        var autoText = findViewById<AutoCompleteTextView>(R.id.autoTextProbarComplete);
        var paises_array:Array<String> = resources.getStringArray(R.array.valores_paises)
        var adaptadorPaises: ArrayAdapter<String> =
            ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, paises_array)
        autoText.setAdapter(adaptadorPaises)
    }
}