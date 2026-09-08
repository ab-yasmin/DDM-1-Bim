package com.example.ex02
import android.graphics.Paint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ex02.model.Tarefa

class TarefaAdapter(private val tarefas: List<Tarefa>) :
    RecyclerView.Adapter<TarefaAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvNome: TextView = itemView.findViewById(R.id.tv_nomeTarefa)
        val tvDescricao: TextView = itemView.findViewById(R.id.tv_descricaoTarefa)
        val cbConcluida: CheckBox = itemView.findViewById(R.id.cb_concluida)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_tarefa, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tarefa = tarefas[position]

        holder.tvNome.text = tarefa.nome
        holder.tvDescricao.text = tarefa.descricao

        holder.cbConcluida.setOnCheckedChangeListener(null)
        holder.cbConcluida.isChecked = tarefa.concluida
        atualizarEstadoVisual(holder, tarefa.concluida)

        holder.cbConcluida.setOnCheckedChangeListener { _, isChecked ->
            tarefa.concluida = isChecked
            atualizarEstadoVisual(holder, isChecked)
        }
    }
    private fun atualizarEstadoVisual(holder: ViewHolder, concluida: Boolean) {
        if (concluida) {
            holder.tvNome.paintFlags = holder.tvNome.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            holder.tvNome.paintFlags = holder.tvNome.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }
    }
    override fun getItemCount(): Int {
        return tarefas.size
    }
}
