package com.example.ex01
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ex01.model.Filme
class FilmeAdapter(private val filmes: List<Filme>) :
    RecyclerView.Adapter<FilmeAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitulo: TextView = itemView.findViewById(R.id.tv_tituloFilme)
        val tvDiretor: TextView = itemView.findViewById(R.id.tv_diretorFilme)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_filme, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val filme = filmes[position]
        holder.tvTitulo.text = filme.titulo
        holder.tvDiretor.text = filme.diretor
    }

    override fun getItemCount(): Int {
        return filmes.size
    }
}
