package com.example.leideohm

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edtTensao = findViewById<EditText>(R.id.edt_tensao)
        val edtResistencia = findViewById<EditText>(R.id.edt_resistencia)
        val edtCorrente = findViewById<EditText>(R.id.edt_corrente)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)
        val txvResultado = findViewById<TextView>(R.id.txv_resultado)

        btnCalcular.setOnClickListener {
            val tensao = edtTensao.text.toString()
            val resistencia = edtResistencia.text.toString()
            val corrente = edtCorrente.text.toString()

            if (tensao.isNotEmpty() && resistencia.isNotEmpty() && corrente.isEmpty()) {
                val v = tensao.toDouble()
                val r = resistencia.toDouble()

                val i = v / r

                txvResultado.text = "Corrente: $i A"

            } else if (tensao.isNotEmpty() && corrente.isNotEmpty() && resistencia.isEmpty()) {
                val v = tensao.toDouble()
                val i = corrente.toDouble()

                val r = v / i
                txvResultado.text = "Resistência: $r Ω"

            } else if (resistencia.isNotEmpty() && corrente.isNotEmpty() && tensao.isEmpty()) {
                val r = resistencia.toDouble()
                val i = corrente.toDouble()

                val v = r * i

                txvResultado.text = "Tensão: $v V"
            }
        }
        }
    }
