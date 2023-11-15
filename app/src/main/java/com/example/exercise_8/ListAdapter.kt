package com.example.exercise_8

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.exercise_8.databinding.ListItemBinding

class ListAdapter(private var data: List<User>): RecyclerView.Adapter<ListAdapter.ListViewHolder>() {

    inner class ListViewHolder(val binding: ListItemBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layoutInflater, parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        holder.binding.apply {
            tvName.text = data[position].name
            tvLastname.text = data[position].lastname
            tvEmail.text = data[position].email
        }

        holder.binding.btnDeleteUser.setOnClickListener {
            Data.deleteUser(position)
            notifyItemRemoved(position)
            notifyItemRangeChanged(0, data.size)
        }

        holder.binding.btnUpdateUser.setOnClickListener {
//            val intent = Intent()
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}


