package com.example.ex01.view
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.ex01.R
import com.example.ex01.dao.FilmeDaoImpl
import com.example.ex01.model.Filme

class CadastroFilmesActivity : AppCompatActivity() {

    private val filmeDao = FilmeDaoImpl()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_filmes)

        val edtTitulo = findViewById<EditText>(R.id.edt_titulo)
        val edtDiretor = findViewById<EditText>(R.id.edt_diretor)
        val btnAdicionar = findViewById<Button>(R.id.btn_adicionar)
        val btnVisualizarFilmes = findViewById<Button>(R.id.btn_visualizar_filmes)

        btnAdicionar.setOnClickListener {
            val titulo = edtTitulo.text.toString()
            val diretor = edtDiretor.text.toString()

            if (titulo.isNotBlank() && diretor.isNotBlank()) {
                val filme = Filme(titulo, diretor)
                filmeDao.adicionarFilme(filme)
                edtTitulo.text.clear()
                edtDiretor.text.clear()
            }
        }
        btnVisualizarFilmes.setOnClickListener {
            finish()
        }
    }
}