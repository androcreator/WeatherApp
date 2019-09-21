package com.app.uitility

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import com.app.weatherforcast.BuildConfig
import okhttp3.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader
import java.lang.StringBuilder
import javax.inject.Inject


class ConnectivityInterceptor @Inject constructor(var context: Context) : Interceptor {
    val TAG:String = javaClass.simpleName.toString()

    override fun intercept(chain: Interceptor.Chain): Response? {

        var response: Response? =null

         if (isConnected() && BuildConfig.BUILD_TYPE.equals("debug")) {
             //MAKING MOCK CALL AS REAL ENDPOINT IS NOT WORKING
             response = mockInterceptor(chain)
         }
        else if (BuildConfig.BUILD_TYPE.equals("release")){
             //MAKE A REAL CALL INCASE OF REAL SERVICE IS WORKING
             response = chain.proceed(chain.request())
         }
         return response
    }

    fun isConnected():Boolean{
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val netInfo = connectivityManager.activeNetworkInfo
        return netInfo!=null && netInfo.isConnected
    }


    fun mockInterceptor(chain: Interceptor.Chain):Response{
        val request = chain.request()
        val path = request.url().encodedPathSegments()[0]
        Log.i("MOCK URL","Mocked Path = $path")
        val stearm = context.assets.open(path)
        val json = parseSteram(stearm)
        return  Response.Builder()
            .body(ResponseBody.create(MediaType.parse("application/json"),json))
            .message("")
            .request(chain.request())
            .protocol(Protocol.HTTP_2)
            .code(200).build()
    }

    fun parseSteram(inputSream:InputStream):String{
        val builder = StringBuilder()
        val reader = BufferedReader(InputStreamReader(inputSream,"UTF-8"))
        val bufferedReader=reader.buffered()
        val iterator = bufferedReader.lineSequence().iterator()
        while (iterator.hasNext()){
            builder.append(iterator.next())
        }
        bufferedReader.close()
        Log.i("MOCK Response","RESPONSE = ${String(builder)}")
        return String(builder)
    }
}

