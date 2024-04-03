package com.example.practice

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.practice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initNavigation()

    }
    private fun initNavigation(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.fr_main,HomeFragment())
            .commitAllowingStateLoss()

        binding.mainBnv.setOnItemSelectedListener{item ->
            when(item.itemId){
                R.id.homeFragment -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fr_main,HomeFragment())
                        .commitAllowingStateLoss()
                    return@setOnItemSelectedListener true
                }

                else -> {return@setOnItemSelectedListener true}
            }
        }
    }
}
