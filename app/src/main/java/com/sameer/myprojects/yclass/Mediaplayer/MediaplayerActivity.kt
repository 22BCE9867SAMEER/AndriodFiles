package com.sameer.myprojects.yclass.Mediaplayer

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Handler
import android.widget.ImageButton
import android.widget.SeekBar
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.sameer.myprojects.R

class MediaplayerActivity : AppCompatActivity() {
    lateinit var mediaplayer :MediaPlayer
    var totaltime:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_mediaplayer)
        mediaplayer = MediaPlayer.create(this,R.raw.darling)
        mediaplayer.setVolume(1f,1f)
        totaltime = mediaplayer.duration
        val bntstop = findViewById<ImageButton>(R.id.imageButtonstop)
        val bntplay = findViewById<ImageButton>(R.id.imageButtonplay)
        val bntpause = findViewById<ImageButton>(R.id.imagepause)
        val seekbar = findViewById<SeekBar>(R.id.seekBarid)
        bntplay.setOnClickListener{
            mediaplayer.start()
        }
        bntpause.setOnClickListener{
            mediaplayer.pause()
        }
        bntstop.setOnClickListener{
            mediaplayer.stop()
            mediaplayer.reset()
            mediaplayer.release()
        } //when ueser changes the time stamps reflect that time stamps
        seekbar.max=totaltime
        seekbar.setOnSeekBarChangeListener(object:SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
               if (fromUser){
                   mediaplayer.seekTo(progress)
               }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {

            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {

            }

        })
            //change the seek bar position with music
        val handler = Handler()
        handler.postDelayed(object:Runnable{
            override fun run() {
                try {
                    seekbar.progress = mediaplayer.currentPosition
                    //says for every 1 sec move th eseek bar with music
                    handler.postDelayed(this,1000)
                }catch (exception:Exception){
                    seekbar.progress=0
                }
            }

        },0)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}