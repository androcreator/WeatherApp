package com.app.weatherforcast.view


import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@LargeTest
@RunWith(AndroidJUnit4::class)
class WeatherActivityTest {
    @Rule
    @JvmField
    var mActivityTestRule = ActivityTestRule(WeatherInfoActivity::class.java)


    @Test
    fun weatherActivityTest() {
        Thread.sleep(1000)//Instead of this we can use Idling Resourse
        onView(withId(com.app.weatherforcast.R.id.weather_container)).check(matches(isDisplayed()))
        onView(withId(com.app.weatherforcast.R.id.bottomsheetdata_lv)).check(matches(isDisplayed()))
    }
}
