package com.example.ex02.dao
import com.example.ex02.model.Tarefa

interface TarefaDao {
    fun adicionarTarefa(tarefa: Tarefa)
    fun obterTarefas(): List<Tarefa>
}