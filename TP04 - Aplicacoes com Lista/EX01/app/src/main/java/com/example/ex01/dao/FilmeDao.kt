package com.example.ex01.dao
import com.example.ex01.model.Filme

interface FilmeDao {
    fun adicionarFilme(filme: Filme)
    fun obterFilmes(): List<Filme>
}