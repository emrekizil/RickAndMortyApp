package com.example.emrekizil_usgstajyerchallenge.ui.splash


import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.emrekizil_usgstajyerchallenge.R
import com.example.emrekizil_usgstajyerchallenge.ui.MainActivity


@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity(R.layout.activity_splash) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        delay()
    }


    private fun delay(){
        val timer= object : CountDownTimer(2000,50){
            override fun onTick(p0: Long) {
            }
            override fun onFinish() {
                startActivity(Intent(this@SplashActivity,MainActivity::class.java))
                finish()
            }
        }
        timer.start()
    }
}