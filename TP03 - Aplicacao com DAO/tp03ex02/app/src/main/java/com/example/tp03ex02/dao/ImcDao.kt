package com.example.tp03ex02.dao
import com.example.tp03ex02.model.Imc
class ImcDao {
    companion object {
        var imc: Imc? = null
    }
    fun salvar(peso:Double,altura:Double){
        imc = Imc(peso,altura)
    }
    fun buscar():Imc?{
        return imc
    }
}