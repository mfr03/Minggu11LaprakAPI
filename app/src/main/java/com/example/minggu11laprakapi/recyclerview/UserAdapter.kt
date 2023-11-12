package com.example.minggu11laprakapi.recyclerview


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.minggu11laprakapi.databinding.ItemUserBinding
import com.example.minggu11laprakapi.model.forapi.UserData

typealias OnClickUser = (UserData) -> Unit
class UserAdapter(private val userList: List<UserData>, private val onClickUser: OnClickUser)
    : RecyclerView.Adapter<UserAdapter.ItemUserViewHolder>() {
    inner class ItemUserViewHolder(private val binding : ItemUserBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(userData: UserData){

            with(binding) {
                name.text = userData.player.name
                level.text = "Lvl. " + userData.player.level.toString()
                uid.text = userData.player.uid

                achievementCount.text = userData.playerSpaceInfo.achievementCount.toString()
                characterCount.text = userData.playerSpaceInfo.avatarCount.toString()
                itemView.setOnClickListener {
                    onClickUser(userData)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemUserViewHolder {
        val binding = ItemUserBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ItemUserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: ItemUserViewHolder, position: Int) {
        holder.bind(userList[position])
    }
}