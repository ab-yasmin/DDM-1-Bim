package com.example.cadastrolivros

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val edtLivro = findViewById<EditText>(R.id.edt_livro)
        val edtAutor = findViewById<EditText>(R.id.edt_autor)
        val btnCadastrar = findViewById<Button>(R.id.btn_cadastrar)
        val fabAvanca = findViewById<FloatingActionButton>(R.id.fab_avanca)

        var nomeLivro = ""
        var nomeAutor = ""

        btnCadastrar.setOnClickListener {
            nomeLivro = edtLivro.text.toString()
            nomeAutor = edtAutor.text.toString()
            edtLivro.text.clear()
            edtAutor.text.clear()
            Toast.makeText(this, "Livro cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
        }

        fabAvanca.setOnClickListener {
            val intent = Intent(this, ViewActivity::class.java)
            intent.putExtra("nome_livro", nomeLivro)
            intent.putExtra("nome_autor", nomeAutor)
            startActivity(intent)
        }
    }
}