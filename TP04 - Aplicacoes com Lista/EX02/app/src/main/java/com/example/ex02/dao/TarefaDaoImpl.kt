package com.example.ex02.dao

import com.example.ex02.model.Tarefa

class TarefaDaoImpl : TarefaDao {
    companion object {
        private val tarefas: MutableList<Tarefa> = mutableListOf()
    }
    override fun adicionarTarefa(tarefa: Tarefa) {
        Companion.tarefas.add(tarefa)
    }
    override fun obterTarefas(): List<Tarefa> {
        return Companion.tarefas
    }
}