package com.example.creditgo.ui

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.creditgo.R
import com.example.creditgo.databinding.ItemUsersBinding
import com.example.creditgo.model.DataResponseItem
import com.example.creditgo.utils.ClickListener
import com.squareup.picasso.Picasso


class UsersAdapter(private val items: ArrayList<DataResponseItem>) :
    RecyclerView.Adapter<UsersAdapter.UserViewHolder>() {
    var viewClick: ClickListener? = null

    class UserViewHolder(private val itemBinding: ItemUsersBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {


        fun bind(user: DataResponseItem?, viewClick: ClickListener?) {
            itemBinding.apply {
                name.text = user?.name + " "+adapterPosition
                type.text = user?.owner?.typeOwner
                defaultBranch.text = user?.defaultBranch
                if (user?.owner?.avatarUrlOwner != null) {
                    Picasso.get().load(user.owner!!.avatarUrlOwner)
                        .placeholder(R.drawable.placeholder)
                        .into(userImg)
                } else {
                    userImg.setImageResource(R.drawable.placeholder)
                }
            }
            itemBinding.card.setOnClickListener {
                viewClick?.click(it, adapterPosition)
            }
        }


    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val itemBinding =
            ItemUsersBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UserViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(items[position],viewClick)
    }

    override fun getItemCount(): Int = items.size

    fun setClickListener(clickListener: ClickListener) {
        viewClick = clickListener
    }

    @SuppressLint("NotifyDataSetChanged")
    fun insertAll(list: ArrayList<DataResponseItem>) {
        items.addAll(list)
        notifyDataSetChanged()

    }
}