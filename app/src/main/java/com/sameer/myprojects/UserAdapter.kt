package com.sameer.myprojects

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth

class UserAdapter(
    val context: Context,
    val userList: ArrayList<User>,
    val imagePickListener: OnImagePickListener
) : RecyclerView.Adapter<UserAdapter.UserViewHolder>() {

    interface OnImagePickListener {
        fun onImagePick()
    }

    class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textName: TextView = itemView.findViewById(R.id.textofuser)
        val imgForUser: ImageView = itemView.findViewById(R.id.imgforuser)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view: View = LayoutInflater.from(context).inflate(R.layout.userdetails, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        val currentUser = userList[position]

        if (FirebaseAuth.getInstance().currentUser?.uid == currentUser.uid) {
            holder.imgForUser.setImageResource(R.drawable.rohit1)
        }

        holder.imgForUser.setOnClickListener {
            imagePickListener.onImagePick()
        }

        holder.textName.text = currentUser.name
        holder.itemView.setOnClickListener {
            val intent = Intent(context, WorkingchatActivity::class.java)
            intent.putExtra("name", currentUser.name)
            intent.putExtra("uid", currentUser.uid)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return userList.size
    }
}
