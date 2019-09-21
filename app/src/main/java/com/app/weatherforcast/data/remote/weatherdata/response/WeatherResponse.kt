package com.app.weatherforcast.data.remote.weatherdata.response

data class WeatherResponse(
    val current: Current,
    val forecastday: List<Forecastday>,
    val location: String
)

data class Current(
    val temp_c: Double
)

data class Forecastday(
    var date: String,
    val day: Day
)

data class Day(
    val temp_c: Double
)