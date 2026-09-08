package com.example.aula03.dao

import com.example.aula03.model.Aluno


class AlunoDao {
    companion object {
        var aluno: Aluno? = null
    }
    fun salvar(nome:String,turma:String){
        aluno = Aluno(nome,turma)
    }
    fun buscar():Aluno?{
        return aluno
    }
}