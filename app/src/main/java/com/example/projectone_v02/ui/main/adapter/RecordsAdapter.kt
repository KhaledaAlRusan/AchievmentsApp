package com.example.projectone_v02.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectone_v02.data.model.Record
import com.example.projectone_v02.databinding.RowMedalBinding

class RecordsAdapter(private val list:List<Record>):RecyclerView.Adapter<RecordsAdapter.MedalViewHolder>() {
    class MedalViewHolder(private val binding:RowMedalBinding):RecyclerView.ViewHolder(binding.root) {
        fun bind(item:Record){
            binding.model = item
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedalViewHolder {
        val binding = RowMedalBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MedalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MedalViewHolder, position: Int) {
        val record = list[position]
        holder.bind(record)
    }

    override fun getItemCount(): Int = list.size
}

