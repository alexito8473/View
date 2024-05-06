package com.example.ejercicioclasesvista.PrimerAplicacion

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import com.example.ejercicioclasesvista.R
import java.util.regex.Matcher
import java.util.regex.Pattern

class CalculadoraActivity : AppCompatActivity() {
    private lateinit var butNumero0: AppCompatButton
    private lateinit var butNumero1: AppCompatButton
    private lateinit var butNumero2: AppCompatButton
    private lateinit var butNumero3: AppCompatButton
    private lateinit var butNumero4: AppCompatButton
    private lateinit var butNumero5: AppCompatButton
    private lateinit var butNumero6: AppCompatButton
    private lateinit var butNumero7: AppCompatButton
    private lateinit var butNumero8: AppCompatButton
    private lateinit var butNumero9: AppCompatButton
    private lateinit var butSuma: AppCompatButton
    private lateinit var butRecta: AppCompatButton
    private lateinit var butMultiplicacion: AppCompatButton
    private lateinit var butDivision: AppCompatButton
    private lateinit var butBorrar: AppCompatButton
    private lateinit var butFibo: AppCompatButton
    private lateinit var butFacto: AppCompatButton
    private lateinit var butResultado: AppCompatButton
    private lateinit var butBorrarTodo: AppCompatButton
    private lateinit var textVisual: TextView
    private lateinit var textAdvertencia: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadora)
        initVariable()
        initboton()
    }

    private fun initVariable() {
        butNumero0 = findViewById(R.id.butCalculadoraN0)
        butNumero1 = findViewById(R.id.butCalculadoraN1)
        butNumero2 = findViewById(R.id.butCalculadoraN2)
        butNumero3 = findViewById(R.id.butCalculadoraN3)
        butNumero4 = findViewById(R.id.butCalculadoraN4)
        butNumero5 = findViewById(R.id.butCalculadoraN5)
        butNumero6 = findViewById(R.id.butCalculadoraN6)
        butNumero7 = findViewById(R.id.butCalculadoraN7)
        butNumero8 = findViewById(R.id.butCalculadoraN8)
        butNumero9 = findViewById(R.id.butCalculadoraN9)
        butSuma = findViewById(R.id.butCalculadoraSuma)
        butRecta = findViewById(R.id.butCalculadoraResta)
        butMultiplicacion = findViewById(R.id.butCalculadoraMultiplicacion)
        butDivision = findViewById(R.id.butCalculadoraDivision)
        butBorrar = findViewById(R.id.butCalculadoraBorrar)
        butFibo = findViewById(R.id.butCalculadoraFibonacci)
        butFacto = findViewById(R.id.butCalculadoraFactorial)
        butResultado = findViewById(R.id.butCalculadoraRersutlado)
        butBorrarTodo = findViewById(R.id.butCalculadoraBorradoGeneral)
        textVisual = findViewById(R.id.textCalculadoraResultado)
        textAdvertencia = findViewById(R.id.textCalculadoraAdvertencia)
    }

    private fun initboton() {
        butNumero0.setOnClickListener { controlNumerico(butNumero0) }
        butNumero1.setOnClickListener { controlNumerico(butNumero1) }
        butNumero2.setOnClickListener { controlNumerico(butNumero2) }
        butNumero3.setOnClickListener { controlNumerico(butNumero3) }
        butNumero4.setOnClickListener { controlNumerico(butNumero4) }
        butNumero5.setOnClickListener { controlNumerico(butNumero5) }
        butNumero6.setOnClickListener { controlNumerico(butNumero6) }
        butNumero7.setOnClickListener { controlNumerico(butNumero7) }
        butNumero8.setOnClickListener { controlNumerico(butNumero8) }
        butNumero9.setOnClickListener { controlNumerico(butNumero9) }
        butSuma.setOnClickListener { controlOperadoresSumaRecta(butSuma) }
        butRecta.setOnClickListener { controlOperadoresSumaRecta(butRecta) }
        butMultiplicacion.setOnClickListener { controlOperadoresDividirMultiplicar(butMultiplicacion) }
        butDivision.setOnClickListener { controlOperadoresDividirMultiplicar(butDivision)}
        butBorrar.setOnClickListener {
            val contenido = textVisual.text.toString()
            textAdvertencia.setText("")
            if (contenido.isEmpty()) {
                textAdvertencia.setText("No se puede borrar algo que no existe")
            } else {
                textVisual.setText(contenido.substring(0, contenido.length - 1))
            }
        }
        butBorrarTodo.setOnClickListener {
            textAdvertencia.setText("")
            if (textVisual.text.toString().isEmpty()) {
                textAdvertencia.setText("No se puede borrar algo que no existe")
            } else {
                textVisual.setText("")
            }
        }
        butFacto.setOnClickListener { controladorParaFiboFacto(false) }
        butFibo.setOnClickListener { controladorParaFiboFacto(true) }
        butResultado.setOnClickListener { coltrolResultado() }
    }

    private fun controladorParaFiboFacto(controlador: Boolean) {
        val patternOperacion = "[+|-]?[0-9]+[+|\\-|x|%][+|-]?[0-9]+"
        val patternNumero = "[+|-]?[0-9]+"
        val contenido = textVisual.text.toString()
        textAdvertencia.setText("")
        if (contenido.isEmpty()) {
            textAdvertencia.setText("No has introducido ningun dato")
        } else {
            if (Pattern.compile(patternOperacion).matcher(contenido).matches()) {
                operacionBuscador()
                if (controlador) {
                    preparacionFibonacci();
                } else {
                    preparacionFactorial();
                }
            } else if (Pattern.compile(patternNumero).matcher(contenido).matches()) {
                if (controlador) {
                    preparacionFibonacci();
                } else {
                    preparacionFactorial();
                }
            } else {
                textAdvertencia.setText("Operación incorrecta")
            }
        }
    }

    private fun preparacionFibonacci() {
        val numerofibbo: Int;
        numerofibbo = fiboRecur(Integer.valueOf(textVisual.text.toString()));
        if (numerofibbo < 0) {
            textAdvertencia.setText("Finonnaci solo se puede hacer con numeros positivos")
        } else if (numerofibbo == 0) {
            textAdvertencia.setText("El fibbonaci de 0 es 0")
        } else {
            textVisual.setText(numerofibbo.toString())
        }
    }

    private fun preparacionFactorial() {
        val numeroFactorial: Int;
        numeroFactorial = factorialRecur(Integer.valueOf(textVisual.text.toString()));
        if (numeroFactorial < 0) {
            textAdvertencia.setText("Factorial solo se puede hacer con numeros mayores que 0")
        } else {
            textVisual.setText(numeroFactorial.toString())
        }
    }

    fun factorialRecur(dato: Int): Int {
        if (dato >= 0) {
            if (dato == 1 || dato == 0) return 1
            else return dato * factorialRecur(dato - 1)
        }
        return -1
    }

    private fun fiboRecur(numero: Int): Int {
        if (numero < 0) {
            return -1
        }
        if (numero == 0) {
            return 0
        }
        if (numero == 1 || numero == 2) {
            return 1
        }
        return fiboRecur(numero - 1) + fiboRecur(numero - 2)
    }

    private fun coltrolResultado() {
        val patternOperacion = "[+|-]?[0-9]+[+|\\-|x|/][+|-]?[0-9]+"
        val patternNumero = "[+|-]?[0-9]+"
        val contenido = textVisual.text.toString()
        textAdvertencia.setText("")
        if (contenido.isEmpty()) {
            textAdvertencia.setText("No has introducido ningun dato")
        } else {
            if (Pattern.compile(patternOperacion).matcher(contenido).matches()) {
                operacionBuscador()
            } else if (Pattern.compile(patternNumero).matcher(contenido).matches()) {
                textAdvertencia.setText("Solo tienes un número")
            } else {
                textAdvertencia.setText("Operación incorrecta")
            }
        }
    }

    private fun operacionBuscador() {
        val patternOperacion = "([+|-]?[0-9]+)([+|\\-|x|/])([+|-]?[0-9]+)"
        val matcher: Matcher = Pattern.compile(patternOperacion).matcher(textVisual.text.toString())
        var numero1: Int = 0;
        var numero2: Int = 0;
        var operacion: String = "";
        if (matcher.find()) {
            numero1 = Integer.valueOf(matcher.group(1).toString())
            operacion = matcher.group(2).toString()
            numero2 = Integer.valueOf(matcher.group(3).toString())
        }
        if (operacion.equals("/") && numero2 == 0) {
            textAdvertencia.setText("No se puede dividir entre 0")
        } else {
            textVisual.setText(operar(numero1, numero2, operacion).toString())
        }

    }

    private fun operar(numero1: Int, numero2: Int, operacion: String): Int {
        return when (operacion) {
            "+" -> numero1 + numero2
            "-" -> numero1 - numero2
            "x" -> numero1 * numero2
            "/" -> numero1 / numero2
            else -> 0
        }
    }

    private fun controlOperadoresDividirMultiplicar(operador: AppCompatButton) {
        val patternOperación = "[+|-]?[0-9]+"
        val operadorAñadir = operador.text.toString()
        val contenido = textVisual.text.toString()
        textAdvertencia.setText("")
        if (!contenido.isEmpty()) {
            if (Pattern.compile(patternOperación).matcher(contenido).matches()) {
                textVisual.setText(contenido + operadorAñadir);
            }
        }
    }

    private fun controlOperadoresSumaRecta(operador: AppCompatButton) {
        val patternSuccesionOperadores = "[+|-]?[0-9]+[+|\\-|x|/]+[+|-]"
        val patternOperador2 = "[+|-]?[0-9]+[+|\\-|x|/][+-]?[0-9]+"
        val patternOperador = "[+|-]?[0-9]+[+|-]"
        val patternUnicoValor = "[+|-]"
        val operadorAñadir = operador.text.toString()
        val contenido = textVisual.text.toString()
        textAdvertencia.setText("")
        if (contenido.isEmpty()) {
            textVisual.setText(operadorAñadir)
        } else {
            if (Pattern.compile(patternOperador).matcher(contenido).matches() || Pattern.compile(
                    patternOperador2
                ).matcher(contenido).matches() || Pattern.compile(patternUnicoValor)
                    .matcher(contenido).matches() || Pattern.compile(patternSuccesionOperadores)
                    .matcher(contenido).matches()
            ) {
            } else {
                textVisual.setText(contenido + operadorAñadir);
            }
        }
    }

    private fun controlNumerico(numero: androidx.appcompat.widget.AppCompatButton) {
        val patternExpresion = "[+|-]?[0-9]+[+|\\-|x|/][+|-]?"
        val patternExpresion2 = "[+|-]?[0-9]+"
        val patternExpresion3 = "[+|-]?[0-9]+[+|\\-|x|/][+|-]?[0-9]+"
        val patternSimbolos = "[+|-]"
        val numeroAñadir = numero.text.toString();
        val contenido = textVisual.text.toString();
        textAdvertencia.setText("")
        if (contenido.isEmpty()) {
            textVisual.setText(numeroAñadir)
        } else {
            if (Pattern.compile(patternExpresion2).matcher(contenido).matches() || Pattern.compile(
                    patternExpresion3
                ).matcher(contenido).matches() || Pattern.compile(patternExpresion)
                    .matcher(contenido).matches() || Pattern.compile(patternSimbolos)
                    .matcher(contenido).matches()
            ) {
                textVisual.setText(contenido + numeroAñadir);
            }

        }
    }
}