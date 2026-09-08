package com.example.aula03.view

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
import com.example.aula03.R
import com.example.aula03.dao.AlunoDao
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
        val edtNomeAluno = findViewById<EditText>(R.id.edt_nome_aluno)
        val edtTurmaAluno = findViewById<EditText>(R.id.edt_turma_aluno)
        val btnSalvar = findViewById<Button>(R.id.btn_salvar)
        val fabvancaTelaAluno = findViewById<FloatingActionButton>(R.id.fab_avanca)
        val dao = AlunoDao()

        btnSalvar.setOnClickListener{
            val nomeAluno = edtNomeAluno.text.toString()
            val turmaAluno  = edtTurmaAluno.text.toString()
            dao.salvar(nomeAluno, turmaAluno)
            Log.i("ESTADO","SALVO")
        }
        fabvancaTelaAluno.setOnClickListener{
            val intent = Intent(this,AlunoActivity::class.java)
            startActivity(intent)
        }

    }
}