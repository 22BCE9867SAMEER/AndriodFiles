package com.sameer.myprojects

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth

class Adapterformessage(val context: Context, val messagelist: ArrayList<Message>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    //we have to create two methods for this --1 . sender class and other is reciever class
    class SentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //initialization block
        val textSent: TextView = itemView.findViewById(R.id.textView10)
    }

    class ReceiverViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textReceive: TextView = itemView.findViewById(R.id.textviewreceiver)
    }

    val itemReceive = 1
    val itemSent = 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        if (viewType == itemReceive) {
            //need space between texts

            val view: View = LayoutInflater.from(context).inflate(R.layout.recevie, parent, false)
            return ReceiverViewHolder(view)
        } else {
            val view: View = LayoutInflater.from(context).inflate(R.layout.sent, parent, false)
            return SentViewHolder(view)
        }
    }

    override fun getItemCount(): Int {
        return messagelist.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val currentMessage = messagelist[position]
        if (holder.javaClass == SentViewHolder::class.java) {
            val viewHolder = holder as SentViewHolder
            viewHolder.textSent.text = currentMessage.message
        } else {
            val viewHolder = holder as ReceiverViewHolder
            viewHolder.textReceive.text = currentMessage.message
        }
    }

    override fun getItemViewType(position: Int): Int {
        val currentMessage = messagelist[position]
        return if (FirebaseAuth.getInstance().currentUser?.uid == currentMessage.senderid) {
            itemSent
        } else {
            itemReceive
        }
    }
}
