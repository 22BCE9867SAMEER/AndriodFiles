package com.sameer.myprojects.yclass.Api

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RatingBar
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView.ItemView
import androidx.lifecycle.findViewTreeViewModelStoreOwner
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.sameer.myprojects.R
import com.squareup.picasso.Picasso

class Myadapter2(val context : Activity, val productarraylist : List<Product>):
RecyclerView.Adapter<Myadapter2.MyViewHolder>(){
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
           var title : TextView
           var image : ShapeableImageView
           var rate : RatingBar
           init{
               title = itemView.findViewById(R.id.title)
               image = itemView.findViewById(R.id.image)
               rate = itemView.findViewById(R.id.rate)
           }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myadapter2.MyViewHolder {

        val itemView = LayoutInflater.from(context).inflate(R.layout.eachiteamdesign, parent , false)
        return MyViewHolder(itemView)
    }


    override fun onBindViewHolder(holder: Myadapter2.MyViewHolder, position: Int) {
        //bind th edata here
        var cuureentpos = productarraylist[position]
        holder.title.text =  cuureentpos.title
        holder.rate.rating = cuureentpos.rating.toFloat()
        //implement the image with the url
        //gettting img with the help oof the url
        //by using the picasso
        Picasso.get().load(cuureentpos.thumbnail).into(holder.image)




    }

    override fun getItemCount(): Int {
       return productarraylist.size
    }
}