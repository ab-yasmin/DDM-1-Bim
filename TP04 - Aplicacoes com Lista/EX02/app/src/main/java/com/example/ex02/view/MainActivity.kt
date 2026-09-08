package com.example.ex02.view
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.ex02.R
import com.example.ex02.dao.TarefaDaoImpl
import com.example.ex02.model.Tarefa

class MainActivity : AppCompatActivity() {
    private val tarefaDao = TarefaDaoImpl()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edtNome = findViewById<EditText>(R.id.edt_nome)
        val edtDescricao = findViewById<EditText>(R.id.edt_descricao)
        val btnAdicionar = findViewById<Button>(R.id.btn_adicionar)
        val btnListarTarefas = findViewById<Button>(R.id.btn_listar_tarefas)

        btnAdicionar.setOnClickListener {
            val nome = edtNome.text.toString()
            val descricao = edtDescricao.text.toString()
            val tarefa = Tarefa(nome, descricao)
            tarefaDao.adicionarTarefa(tarefa)
            edtNome.text.clear()
            edtDescricao.text.clear()
        }
        btnListarTarefas.setOnClickListener {
            val intent = Intent(this, ListaTarefasActivity::class.java)
            startActivity(intent)
        }
    }
}