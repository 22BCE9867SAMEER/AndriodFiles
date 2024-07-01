package com.sameer.myprojects.yclass.RecyclerView

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.google.android.material.shape.Shapeable
import com.sameer.myprojects.R
import com.sameer.myprojects.yclass.Myadapter
import java.util.ArrayList

class Myadapter1(private val newarraylist : ArrayList<News>, private val context:Activity):
RecyclerView.Adapter<Myadapter1.MyViewHolder>(){
    private  lateinit var mylisterner:onitemclicklisterner
    //create an interface
    interface onitemclicklisterner{
        fun onitemclick(position:Int)

    }

    fun setonitemclicklisterner(listerner:onitemclicklisterner){
        mylisterner=listerner
    }
//to create the new view instance
    //when layout manager fails to find a suitable view for each iteam int he list
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myadapter1.MyViewHolder {
        val itemview = LayoutInflater.from(parent.context).inflate(R.layout.eachrow,parent,false)
       return MyViewHolder(itemview,mylisterner)
    }
//populates item with    the data z

    override fun onBindViewHolder(holder: Myadapter1.MyViewHolder, position: Int) {
        var cuurentiteam = newarraylist[position]
        holder.headinf.text=cuurentiteam.newsheading
        holder.img.setImageResource(cuurentiteam.newsimage)

    }
 //returns the total count all iteam in the recyclerview
    override fun getItemCount(): Int {
        return newarraylist.size

    }//it holds the views so the view are created evertime and memory is saved
    class MyViewHolder(itemView :View,listerner:onitemclicklisterner):RecyclerView.ViewHolder(itemView) {
        val headinf = itemView.findViewById<TextView>(R.id.textheading)
        val img = itemView.findViewById<ShapeableImageView>(R.id.newsimg)
        init{
            itemView.setOnClickListener{
                listerner.onitemclick(adapterPosition)
            }
        }

    }


}
