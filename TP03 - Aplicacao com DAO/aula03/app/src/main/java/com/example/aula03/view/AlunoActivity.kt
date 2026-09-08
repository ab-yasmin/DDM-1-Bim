package com.example.aula03.view

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.aula03.R
import com.example.aula03.dao.AlunoDao
import com.google.android.material.floatingactionbutton.FloatingActionButton
import kotlin.random.Random

class AlunoActivity : AppCompatActivity(R.layout.activity_aluno) {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_aluno)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val txvNomeAluno = findViewById<TextView>(R.id.txv_nome_aluno)
        val btnGerarMatricula = findViewById<Button>(R.id.btn_gera_matricula)
        var txvMatricula = findViewById<TextView>(R.id.txv_matricula)
        val txvTurmaAluno = findViewById<TextView>(R.id.txv_turma)
        val fabVoltaTelaCadastro = findViewById<FloatingActionButton>(R.id.fab_volta)
        val dao = AlunoDao()
        txvNomeAluno.setText("Nome:${dao.buscar()?.nome}")
        txvTurmaAluno.setText("Nome:${dao.buscar()?.turma}")

        btnGerarMatricula.setOnClickListener{
            val codigo =  Random.nextInt(0, 60000)
            txvMatricula.text = codigo.toString()        }

        fabVoltaTelaCadastro.setOnClickListener{
            finish()
        }
    }
}