package com.app.weatherforcast.view

import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.util.Log
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.app.uitility.BottomSheetComponent
import com.app.uitility.utils
import com.app.weatherforcast.R
import com.app.weatherforcast.data.remote.weatherdata.response.WeatherResponse
import com.app.weatherforcast.viewmodel.ViewModelFactory
import com.app.weatherforcast.viewmodel.WeatherInfoViewlModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class WeatherInfoActivity : AppCompatActivity() {

    lateinit var weatherObserver: Observer<WeatherResponse>

    lateinit var weatherInfoViewmodel: WeatherInfoViewlModel

    @Inject
    lateinit var viewModelFactory: ViewModelFactory<WeatherInfoViewlModel>

    @Inject
    lateinit var weatherLiveData: MutableLiveData<WeatherResponse>



    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.app.weatherforcast.R.layout.activity_main)
        AndroidInjection.inject(this)
        //SETP 1 Initialise the Viewmodel
        initViewModel()
        //STEP 2  Make call to Weather API.
        fetchWeather()
        weatherdataObserver()
    }


    /**
     * This Method initialise the Viewmodel for injection
     */
    fun initViewModel(){
        weatherInfoViewmodel =  ViewModelProviders.of(this,viewModelFactory).get(WeatherInfoViewlModel::class.java)
    }


    fun fetchWeather(){
        weatherInfoViewmodel.weatherInfo()
    }
    
    
    fun weatherdataObserver(){
        weatherObserver = Observer{
            Log.i("GOT LIVEDATA","live data: $it")
            val placeNameFromGeoCoder = utils.getAddress(this,it.location.split(",")[0].toDouble(),it.location.split(",")[1].toDouble())
            current_degree_TV.text = it.current.temp_c.toString()+ 0x00B0.toChar()
            place_TV.text = placeNameFromGeoCoder
            Handler().postDelayed(Runnable {
                // This method will be executed once the timer is over
                BottomSheetComponent(this,it.forecastday, R.style.AppTheme_bottomSheet).show()  //STEP 3 Populate Bootom Sheet with data.
            }, 1000)
            weatherLiveData.removeObserver(weatherObserver)
        }
        weatherLiveData.observe(this,weatherObserver)
    }
}



