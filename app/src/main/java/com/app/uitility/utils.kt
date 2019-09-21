package com.app.uitility

import android.content.Context
import android.icu.text.SimpleDateFormat
import android.location.Geocoder
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import java.io.IOException
import java.text.ParseException
import java.util.*


class utils {

    companion object{

        /**
         * To get Locality name from LAT & LAN
         */
        fun getAddress(ctx: Context, lat: Double, lng: Double) :String?{
            var locality:String?
            val geocoder = Geocoder(ctx, Locale.getDefault())
            try {
                val addresses = geocoder.getFromLocation(lat, lng, 1)
                val obj = addresses[0]
                locality =  obj.locality
                Log.v("IGA", "Address$locality")
            } catch (e: IOException) {
                e.printStackTrace()
                locality = "Not Found"
                Log.v("Location Error", "${e.message}")
            }
        return locality
        }

        /**
         *To get day from UTC Time format
         */
        @RequiresApi(Build.VERSION_CODES.N)
        fun getDateFromUTCTimeFormat(string: String):String?{
            val dayFromDate:String
            val inputFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val outputFormat = SimpleDateFormat("dd-MM-yyyy")
            //val date = inputFormat.parse("2018-04-10T04:00:00.000Z")
            val formatedDate = inputFormat.parse(string)
            Log.i("DATE","Formated Date:=$formatedDate")

            val date:Date? = outputFormat.parse(string)
            val dayFormate = SimpleDateFormat("EEEE")
            dayFromDate = dayFormate.format(date)
            Log.d("DAY", ":: $dayFromDate")
            return dayFromDate
        }
    }
}