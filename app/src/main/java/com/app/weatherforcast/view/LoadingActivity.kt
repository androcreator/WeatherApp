package com.app.weatherforcast.view

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_error.*


class LoadingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.app.weatherforcast.R.layout.activity_loading)


        Handler().postDelayed(Runnable {
            // This method will be executed once the timer is over
            if(isConnected()){
                val i = Intent(this@LoadingActivity, WeatherInfoActivity::class.java)
                startActivity(i)
                finish()
            }else{
                setContentView(com.app.weatherforcast.R.layout.activity_error)
                retry_btn.setOnClickListener {
                        view -> startActivity(Intent(this, WeatherInfoActivity::class.java))
                }
            }

        }, 3000)

    }

    fun isConnected():Boolean{
        val connectivityManager = this.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return netInfo!=null && netInfo.isConnected
    }


}
