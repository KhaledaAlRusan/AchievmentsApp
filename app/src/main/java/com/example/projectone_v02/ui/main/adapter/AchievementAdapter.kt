package com.example.projectone_v02.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.projectone_v02.data.model.Data
import com.example.projectone_v02.databinding.RowAchievementsBinding
import com.example.projectone_v02.databinding.RowMedalBinding

class AchievementAdapter(private val list:List<Data>):
    RecyclerView.Adapter<AchievementAdapter.MedalViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MedalViewHolder {
        val binding = RowAchievementsBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MedalViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MedalViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount() = list.size






    class MedalViewHolder(private val binding:RowAchievementsBinding):
    RecyclerView.ViewHolder(binding.root)
    {
        fun bind(model:Data){
            binding.model = model
            binding.rvMedals.adapter = RecordsAdapter(model.records)
        }
    }


}