package com.sokolang.cristallball

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sokolang.cristallball.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.tvReto.setOnClickListener{
            binding.tvReto.text = getReto()
        }
    }
    private fun getReto(): String{
        return resources.getStringArray(R.array.retos)[randomNumber()]
    }
    private fun randomNumber(): Int{
        val size = resources.getStringArray(R.array.retos).size - 1
        return (0..size).random()
    }
}