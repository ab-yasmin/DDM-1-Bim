package com.example.cadastrolivros

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ViewActivity : AppCompatActivity(R.layout.activity_view) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val txvDados = findViewById<TextView>(R.id.txv_dados)
        val fabVolta = findViewById<FloatingActionButton>(R.id.fab_volta)

        val nomeLivro = intent.getStringExtra("nome_livro")
        val nomeAutor = intent.getStringExtra("nome_autor")
        txvDados.setText("Título da obra: $nomeLivro\nAutor: $nomeAutor")

        fabVolta.setOnClickListener {
            finish()
        }
    }
}