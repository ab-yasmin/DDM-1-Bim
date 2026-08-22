package com.example.conversorfahrenheit

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import android.widget.TextView
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edtValor1 = findViewById<EditText>(R.id.edt_valor1)
        val btnConverter = findViewById<Button>(R.id.btn_converter)
        val txvResultado = findViewById<TextView>(R.id.txv_resultado)

        btnConverter.setOnClickListener{
            val valorCelsius = edtValor1.text.toString().toDouble()
            val resultado = valorCelsius * 1.8 + 32
            txvResultado.setText("Valor em Fahrenheit:\n$resultado")

        }
    }
}