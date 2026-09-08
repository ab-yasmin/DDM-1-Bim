package com.example.ex01.dao

import com.example.ex01.model.Filme

class FilmeDaoImpl : FilmeDao {
    companion object {
        private val filmes: MutableList<Filme> = mutableListOf(
            Filme("Shrek 2", "Andrew Adamson"),
            Filme("Pinóquio", "Guillermo del Toro"),
            Filme("De Volta para o Futuro", "Robert Zemeckis")
        )
    }
    override fun adicionarFilme(filme: Filme) {
        filmes.add(filme)
    }
    override fun obterFilmes(): List<Filme> {
        return filmes
    }
}