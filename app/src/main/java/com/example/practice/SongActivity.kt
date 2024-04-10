package com.example.practice

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.practice.data.Song
import com.example.practice.databinding.ActivityMainBinding
import com.example.practice.databinding.ActivitySongBinding

class SongActivity : AppCompatActivity() {

    private val song = Song("", "")
    private lateinit var binding: ActivitySongBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySongBinding.inflate(layoutInflater)
        setContentView(binding.root)
        onClickBackButton()
        bringIntentData()
    }

    private fun bringIntentData() {
        with(song) {
            with(intent) {
                singer = getStringExtra("singer").toString()
                title = getStringExtra("title").toString()
            }
        }

        with(binding) {
            with(song) {
                songTitleTv.text = title
                songSingerTv.text = singer
            }
        }
    }

    private fun playSongState(state: Boolean) {
        with(binding) {
            if (state) {
                songPlayBt.visibility = View.VISIBLE
                songPauseBt.visibility = View.GONE
            }
            else{
                songPauseBt.visibility = View.VISIBLE
                songPlayBt.visibility = View.GONE
            }
        }
    }

    private fun playLikeState(state: Boolean) {
        with(binding) {
            if (state) {
                songLikeOnBtn.visibility = View.VISIBLE
                songLikeBtn.visibility = View.GONE
            }
            else{
                songLikeBtn.visibility = View.VISIBLE
                songLikeOnBtn.visibility = View.GONE
            }
        }
    }

    private fun playUnLikeState(state: Boolean) {
        with(binding) {
            if (state) {
                songUnlikeOnBtn.visibility = View.VISIBLE
                songUnlikeBtn.visibility = View.GONE
            }
            else{
                songUnlikeBtn.visibility = View.VISIBLE
                songUnlikeOnBtn.visibility = View.GONE
            }
        }
    }
    private fun onClickBackButton() {
        with(binding) {
            songDropButtonIbt.setOnClickListener {
                val intent = Intent(this@SongActivity, MainActivity::class.java).apply {
                    putExtra(MainActivity.STRING_INTENT_KEY, binding.songTitleTv.text.toString())
                }
                setResult(Activity.RESULT_OK, intent)
                if (!isFinishing)
                    finish()
            }

            songPlayBt.setOnClickListener{
                playSongState(false)
            }
            songPauseBt.setOnClickListener {
                playSongState(true)
            }
            songUnlikeBtn.setOnClickListener {
                playUnLikeState(true)
            }
            songUnlikeOnBtn.setOnClickListener {
                playUnLikeState(false)
            }
            songLikeBtn.setOnClickListener{
                playLikeState(true)
            }
            songLikeOnBtn.setOnClickListener{
                playLikeState(false)
            }


        }
    }
}