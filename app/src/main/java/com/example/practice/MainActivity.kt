package com.example.practice

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ReportFragment.Companion.reportFragment
import com.example.practice.data.Song
import com.example.practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var resultIntent : ActivityResultLauncher<Intent>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigation()
        onClickButton()
        setResultIntent()

    }

    private fun initNavigation() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fr_main, HomeFragment())
            .commitAllowingStateLoss()

        binding.mainBnv.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fr_main, HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                else -> {
                    return@setOnItemSelectedListener true
                }
            }
        }
    }


    private fun setResultIntent(){
        resultIntent = registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()
        ) {
            if (it.resultCode == Activity.RESULT_OK) {
                val returnResult = it.data?.getStringExtra(STRING_INTENT_KEY)
                Toast.makeText(this, returnResult, Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun onClickButton() {
        val song = Song("","")
        with(binding){
            song.singer = mainMiniplayerSingerTv.text.toString()
            song.title = mainMiniplayerTitleTv.text.toString()
        }
        binding.mainPlayerCl.setOnClickListener {
            val intent = Intent(this,SongActivity::class.java).apply {
                putExtra("title", song.title)
                putExtra("singer", song.singer)
            }
            resultIntent.launch(intent)
        }
    }

    companion object {
        const val STRING_INTENT_KEY = "intent_key"
    }
}

