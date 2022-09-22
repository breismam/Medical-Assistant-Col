package com.example.myapplication.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.data.models.DoctorModel
import com.example.myapplication.interfaces.OnDoctorClickListener
import com.example.myapplication.databinding.ItemDoctorBinding


class DoctorAdapter(var list: List<DoctorModel>) : RecyclerView.Adapter<DoctorAdapter.ViewHolder>() {


     var listener: OnDoctorClickListener? = null

    class ViewHolder(val view: ItemDoctorBinding) : RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemDoctorBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.view.itemDoctorTitle.text = item.speciality
        holder.view.itemDoctorName.text = item.name
        holder.view.itemDoctorSummary.text = item.caption
        holder.view.itemDoctorRating.rating = (item.star / 5.0).toFloat()
        holder.view.itemDoctorIcon.setImageResource(item.image.toInt())
        holder.view.root.setOnClickListener {
            listener?.onClick(item)
        }
    }

        override fun getItemCount(): Int {
            return list.size
        }

     fun changeDataSet(newList: List<DoctorModel>){
         this.list = newList
         notifyDataSetChanged()
     }
    }

