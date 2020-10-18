package com.example.neopyme.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.neopyme.R
import com.example.neopyme.network.DTO.SimpleDataDTO

class DataCustom(val context: Context) : BaseAdapter() {

    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    var dataSource = emptyList<SimpleDataDTO>()

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val vh: ItemHolder
        if (convertView == null) {
            view = inflater.inflate(R.layout.spinner_personalizado, parent, false)
            vh = ItemHolder(view)
            view?.tag = vh
        } else {
            view = convertView
            vh = view.tag as ItemHolder
        }
        vh.label.text = dataSource[position].text

        return view
    }

    override fun getItem(position: Int): Any {
        return dataSource[position];
    }

    override fun getItemId(position: Int): Long {
        return position.toLong();
    }

    override fun getCount(): Int {
        return dataSource.size;
    }

    internal fun setDataset(data: List<SimpleDataDTO>){
        this.dataSource = data
        notifyDataSetChanged()
    }

    private class ItemHolder(row: View?) {
        val label: TextView

        init {
            label = row?.findViewById(R.id.text) as TextView
        }
    }

}