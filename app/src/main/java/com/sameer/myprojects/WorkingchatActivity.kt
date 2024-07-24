package com.sameer.myprojects

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*

class WorkingchatActivity : AppCompatActivity() {
    private lateinit var recylerviewmsg: RecyclerView
    private lateinit var textmsg: EditText
    private lateinit var btnmsg: ImageView
    private lateinit var messagelist: ArrayList<Message>
    private lateinit var messageadapter: Adapterformessage
    private lateinit var dref: DatabaseReference
    private lateinit var imageupload: ImageView

companion object{
    private val gallerycode = 1000
}

    private var senderroom: String? = null  // this is unique for sender and receiver
    private var receiverroom: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_workingchat)

        //lets us receive the intent here
        val name = intent.getStringExtra("name")
        val reciverid = intent.getStringExtra("uid")

        supportActionBar?.title = name
        val senderuid = FirebaseAuth.getInstance().currentUser?.uid
        senderroom = reciverid + senderuid
        receiverroom = senderuid + reciverid

        recylerviewmsg = findViewById(R.id.recyclerviewforchat)
        textmsg = findViewById(R.id.textmseeage)
        btnmsg = findViewById(R.id.imageViewsendmessgae)
        imageupload = findViewById(R.id.uploadimage)

        messagelist = ArrayList()
        messageadapter = Adapterformessage(this, messagelist)
        recylerviewmsg.layoutManager = LinearLayoutManager(this)
        dref = FirebaseDatabase.getInstance().reference
        recylerviewmsg.adapter = messageadapter

        // Add msg first to database and next to user
        btnmsg.setOnClickListener {
            // Adding message to database
            val message = textmsg.text.toString()
            val messageobject = Message(message, senderuid)
            dref.child("chats").child(senderroom!!).child("messages").push()
                .setValue(messageobject).addOnSuccessListener {
                    dref.child("chats").child(receiverroom!!).child("messages").push()
                        .setValue(messageobject)
                }
            textmsg.setText("")
        }

        dref.child("chats").child(senderroom!!).child("messages")
            .addValueEventListener(object : ValueEventListener {
                override fun onDataChange(snapshot: DataSnapshot) {
                    messagelist.clear()
                    for (postsnap in snapshot.children) {
                        val message = postsnap.getValue(Message::class.java)
                        messagelist.add(message!!)
                    }
                    messageadapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {
                    // Handle database error
                }
            })
        //currently this upload in the progress

        imageupload.setOnClickListener {
            // Open the gallery
            Toast.makeText(this,"currently this button in the process",Toast.LENGTH_SHORT).show()
           val i = Intent(Intent.ACTION_PICK)
            i.type = "image/*"
            startActivityForResult(i, gallerycode)
        }
        @Override
        fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            super.onActivityResult(requestCode, resultCode, data)
            if (requestCode== gallerycode&&resultCode== RESULT_OK){
                imageupload.setImageURI(data?.data)
            }
        }




        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}
