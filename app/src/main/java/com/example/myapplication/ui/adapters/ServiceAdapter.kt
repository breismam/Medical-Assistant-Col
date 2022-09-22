package com.example.myapplication.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.interfaces.OnServiceClickListener
import com.example.myapplication.data.models.ServiceModel
import com.example.myapplication.databinding.ItemServicesBinding

class ServiceAdapter(var list: List<ServiceModel>) : RecyclerView.Adapter<ServiceAdapter.ViewHolder>() {

    var listener: OnServiceClickListener?= null

    class ViewHolder(val view:ItemServicesBinding):RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemServicesBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.view.itemServiceTitle.text = item.title
        holder.view.itemServiceDescription.text = item.description
        holder.view.itemServiceIcon.setImageResource(item.icon.toInt())
        holder.view.root.setOnClickListener {
            listener?.onClick(item)
        }

    }

    override fun getItemCount(): Int {
      return list.size
    }
}