package com.example.tp03ex02.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tp03ex02.R
import com.example.tp03ex02.dao.ImcDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class IMCActivity : AppCompatActivity(R.layout.activity_imcactivity) {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_imcactivity)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txvImc = findViewById<TextView>(R.id.txv_resultado_imc)
        val txvClassificacao = findViewById<TextView>(R.id.txv_classificacao)
        val fabVolta = findViewById<FloatingActionButton>(R.id.fav_volta)
        val dao = ImcDao()

        val dados = dao.buscar()

        val peso = dados?.peso ?: 0.0
        val altura = dados?.altura ?: 0.0

        val imc = peso / (altura * altura)

        txvImc.text = "IMC: %.2f".format(imc)

        if (imc < 18.5) {

            txvClassificacao.text = "Abaixo do peso"

        } else if (imc < 25.0) {

            txvClassificacao.text = "Peso ideal"

        } else if (imc < 30.0) {

            txvClassificacao.text = "Sobrepeso"

        } else {

            txvClassificacao.text = "Obesidade"
        }

        fabVolta.setOnClickListener{
            finish()
        }
    }
    }

