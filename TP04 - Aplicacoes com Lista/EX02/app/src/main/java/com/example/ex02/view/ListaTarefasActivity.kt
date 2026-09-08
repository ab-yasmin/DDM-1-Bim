package com.example.ex02.view
import com.example.ex02.R
import com.example.ex02.TarefaAdapter
import com.example.ex02.dao.TarefaDaoImpl
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListaTarefasActivity : AppCompatActivity() {

    private val tarefaDao = TarefaDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_tarefas)

        val rvTarefas = findViewById<RecyclerView>(R.id.rv_tarefas)
        val fabVoltarCadastro = findViewById<FloatingActionButton>(R.id.fab_voltar_cadastro)
        val tarefas = tarefaDao.obterTarefas()

        rvTarefas.layoutManager = LinearLayoutManager(this)
        rvTarefas.adapter = TarefaAdapter(tarefas)

        fabVoltarCadastro.setOnClickListener {
            finish()
        }
    }
    }
