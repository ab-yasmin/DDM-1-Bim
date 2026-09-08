package com.example.ex01.view
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ex01.FilmeAdapter
import com.example.ex01.R
import com.example.ex01.dao.FilmeDaoImpl

class MainActivity : AppCompatActivity() {
    private val filmeDao = FilmeDaoImpl()
    private lateinit var rvFilmes: RecyclerView
    private lateinit var filmeAdapter: FilmeAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvFilmes = findViewById(R.id.rv_filmes)
        val btnAdicionarFilme = findViewById<Button>(R.id.btn_adicionar_filme)

        val filmes = filmeDao.obterFilmes()

        rvFilmes.layoutManager = GridLayoutManager(this, 2)
        filmeAdapter = FilmeAdapter(filmes)
        rvFilmes.adapter = filmeAdapter

        btnAdicionarFilme.setOnClickListener {
            val intent = Intent(this, CadastroFilmesActivity::class.java)
            startActivity(intent)
        }
    }
    override fun onResume() {
        super.onResume()
        filmeAdapter.notifyDataSetChanged()
    }
}