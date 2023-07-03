package com.example.mynewgamesapp

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import androidx.appcompat.app.AppCompatActivity
import com.example.mynewgamesapp.databinding.ActivitySplashScreenBinding

class SplashScreenActivity: AppCompatActivity() {
    lateinit var binding: ActivitySplashScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val countDownTimer = object : CountDownTimer(6000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val seconds = millisUntilFinished / 1000
                binding.tvSplash.setText(seconds.toString())
            }

            override fun onFinish() {
                launchMainActivity()
            }
        }

        countDownTimer.start()
    }

    fun launchMainActivity(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

}