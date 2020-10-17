package com.example.neopyme.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.neopyme.R
import com.example.neopyme.db.entity.Credito
import kotlinx.android.synthetic.main.item_credito.view.*

class ResultadosAdapter (
    private val context: Context,
    var itemCLickListener: ItemClickListener
) : RecyclerView.Adapter<ResultadosAdapter.WordViewHolder>() {

    interface ItemClickListener {
        fun onItemClick(credito: Credito)
    }

    private var creditos = ArrayList<Credito>()

    inner class WordViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val viewHolder = itemView
        fun setData(credito: Credito) {
            viewHolder.setOnClickListener {itemCLickListener.onItemClick(credito)}
            itemView.nombre_credito.text = credito.nombre
            itemView.descripcion_credito.text = credito.descripcion
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
        return WordViewHolder(LayoutInflater.from(context).inflate(R.layout.item_credito, parent, false))
    }

    override fun getItemCount() = creditos.size

    override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
        holder.setData(creditos[position])
    }

    internal fun setCreditos(creditos: List<Credito>) {
        this.creditos.clear()
        this.creditos.addAll(creditos)
        notifyDataSetChanged()
    }
}