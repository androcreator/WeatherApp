package com.app.weatherforcast.view

import android.app.Activity
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.app.uitility.utils
import com.app.weatherforcast.R
import com.app.weatherforcast.data.remote.weatherdata.response.Forecastday


class ForecastAdapter(var context: Context, var forecastday: List<Forecastday>) : BaseAdapter(){
    override fun getItem(p0: Int): Any {
        return forecastday.get(p0)
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getCount(): Int {
        return forecastday.size
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var holder: ViewHolder?
        var convertView = convertView
        val mInflater = context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        if (convertView == null) {
            holder = ViewHolder()
            convertView = mInflater.inflate(R.layout.bootom_sheet_items, parent, false)
            convertView.tag = holder
            holder.day_tv = convertView!!.findViewById(R.id.day_tv) as TextView
            holder.forecast_tv = convertView!!.findViewById(R.id.weather_tv) as TextView
            holder.day_tv!!.setText( utils.getDateFromUTCTimeFormat(forecastday[position].date))
            holder.forecast_tv!!.setText(forecastday[position].day.temp_c.toString() + " C")
        }
        else{
            holder = convertView.tag as ViewHolder
        }

        return convertView
    }

    private inner class ViewHolder {
        internal var day_tv: TextView? = null
        internal var forecast_tv: TextView? = null
    }
}