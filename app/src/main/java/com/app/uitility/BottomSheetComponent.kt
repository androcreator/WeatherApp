package com.app.uitility

import android.content.Context
import com.app.weatherforcast.data.remote.weatherdata.response.Forecastday
import com.app.weatherforcast.view.ForecastAdapter
import com.google.android.material.bottomsheet.BottomSheetDialog
import kotlinx.android.synthetic.main.bottom_sheet.view.*


/**
 * This class is open to EDIT for new funtonality-SOLID
 */
class BottomSheetComponent(context: Context, var forecastlist:List<Forecastday>, theme: Int) : BottomSheetDialog(context, theme) {

    init {
        create()
    }


    override fun create() {
        val bottomSheetView = layoutInflater.inflate(com.app.weatherforcast.R.layout.bottom_sheet, null)
        val adapter = ForecastAdapter(this.context, forecastlist)
        bottomSheetView.bottomsheetdata_lv.adapter = adapter
        setContentView(bottomSheetView)
    }
}