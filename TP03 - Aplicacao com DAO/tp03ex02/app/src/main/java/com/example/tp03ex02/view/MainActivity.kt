package com.example.tp03ex02.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tp03ex02.R
import com.example.tp03ex02.dao.ImcDao
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val edtPeso = findViewById<EditText>(R.id.edt_peso)
        val edtAltura = findViewById<EditText>(R.id.edt_altura)
        val btnCalcular = findViewById<Button>(R.id.btn_calcular)
        val fabAvancaTelaImc = findViewById<FloatingActionButton>(R.id.fab_avanca)
        val dao = ImcDao()

        btnCalcular.setOnClickListener{
            val peso= edtPeso.text.toString().toDouble()
            val altura  = edtAltura.text.toString().toDouble()
            val ImcResultado = peso/(altura*altura)
            dao.salvar(peso, altura)
            Log.i("ESTADO","SALVO")
        }
        fabAvancaTelaImc.setOnClickListener{
            val intent = Intent(this,IMCActivity::class.java)
            startActivity(intent)
        }
    }
}


