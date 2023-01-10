package com.example.dialoglar.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dialoglar.R
import com.example.dialoglar.databinding.ItemUserBinding
import com.example.dialoglar.model.Dialog

class Adapter (val list:ArrayList<Dialog>) :RecyclerView.Adapter<Adapter.MyViewHolder>(){
    inner class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        fun onBind(dialog: Dialog,position: Int){
            val bind=ItemUserBinding.bind(itemView)
            bind.tvName.text=dialog.name
            bind.tvNumber.text=dialog.number


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_user,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.onBind(list[position],position)
    }

    override fun getItemCount(): Int=list.size

}