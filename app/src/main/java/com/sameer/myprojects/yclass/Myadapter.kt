package com.sameer.myprojects.yclass

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView
import com.sameer.myprojects.R
import de.hdodenhof.circleimageview.CircleImageView

class Myadapter ( private val context: Context,val arrylist:ArrayList<Persons>) :
    ArrayAdapter<Persons>(context, R.layout.eachiteam,arrylist){

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val inflator = LayoutInflater.from(context)
        val view = inflator.inflate(R.layout.eachiteam,null)
        val img = view.findViewById<CircleImageView>(R.id.profile_img)
        val name = view.findViewById<TextView>(R.id.textname)
        val lastmg = view.findViewById<TextView>(R.id.textmsg)
        val lasttime = view.findViewById<TextView>(R.id.texttime)

        name.text=arrylist[position].name
        lastmg.text = arrylist[position].lastmsg
        lasttime.text=arrylist[position].lastmgtime
        img.setImageResource(arrylist[position].imgid)
        return view
    }
}