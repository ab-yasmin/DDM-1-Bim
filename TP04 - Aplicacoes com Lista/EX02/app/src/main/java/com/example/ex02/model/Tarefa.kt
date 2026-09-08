package com.example.ex02.model

data class Tarefa(
    val nome: String = "",
    val descricao: String = "",
    var concluida: Boolean = false
)