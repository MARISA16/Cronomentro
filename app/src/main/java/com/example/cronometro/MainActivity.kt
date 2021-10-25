package com.example.cronometro

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SystemClock
import android.view.LayoutInflater
import com.example.cronometro.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    var running = false
    var pausetopwatch: Long =0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.start.setOnClickListener {
            Starttimer()
        }
        binding.pause.setOnClickListener{
            pausetimer()
        }

        binding.reset.setOnClickListener{
            resettimer()
        }
    }
    private fun Starttimer(){
        if (!running){
            binding.stopwatch.base =SystemClock.elapsedRealtime() -pausetopwatch
            binding.stopwatch.start()
            running =true
        }

    }

    private  fun  pausetimer(){
        if (running){
            binding.stopwatch.stop()
            pausetopwatch = SystemClock.elapsedRealtime() - binding.stopwatch.base
            running =false
        }
    }


    private  fun resettimer(){
        binding.stopwatch.base =SystemClock.elapsedRealtime()
        pausetopwatch=0
    }
}