package com.sameer.myprojects.Projects

import android.app.Activity
import android.media.MediaPlayer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import com.sameer.myprojects.R
import com.squareup.picasso.Picasso

class Myadapter3(val context :Activity , val musiclist : List<Data>):
RecyclerView.Adapter<Myadapter3.MyViewHolder>(){
    class MyViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {
        //define the id of each and very item in this
        var title1 : TextView;
        var movieimage : ImageView
        var imagebuttonplay:ImageButton
        var imagebuttonstop:ImageButton
        init {
            title1 = itemview.findViewById(R.id.imagetext)
            movieimage= itemview.findViewById(R.id.imagemusic)
            imagebuttonplay=itemview.findViewById(R.id.imageButtonmovieplay)
            imagebuttonstop = itemview.findViewById(R.id.imageButtonmoviestop)
        }

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myadapter3.MyViewHolder {
        //layout
        val itemview = LayoutInflater.from(context).inflate(R.layout.foreachiteam,parent,false)
        return MyViewHolder(itemview)
    }
    override fun onBindViewHolder(holder: Myadapter3.MyViewHolder, position: Int) {

        //holds the data
        var currentposition = musiclist[position]
        val mediaplayer = MediaPlayer.create(context,currentposition.preview.toUri())
        holder.title1.text = currentposition.title

        //to set the image

        Picasso.get().load(currentposition.album.cover).into(holder.movieimage)

        holder.imagebuttonplay.setOnClickListener {
            mediaplayer.start()
        }
        holder.imagebuttonstop.setOnClickListener{
            mediaplayer.stop()
        }

    }

    override fun getItemCount(): Int {
        return musiclist.size
    }
}