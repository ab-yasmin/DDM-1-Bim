package com.example.boasvindas

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtIdade = findViewById<EditText>(R.id.edt_idade)
        val btnResultado = findViewById<Button>(R.id.btn_enviar)
        val txvResultado = findViewById<TextView>(R.id.txv_resultado)

        btnResultado.setOnClickListener {
            val nome = edtNome.text.toString()
            val idade = edtIdade.text.toString()
            txvResultado.setText("Boas Vindas!\nDados Cadastrados:$nome,$idade")
        }
        }
    }