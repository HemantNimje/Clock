package com.hemant.clock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import androidx.fragment.app.commit

//1. Create a digital clock that displays the current time in 11:59:01 PM format, updating every second.
//2. Create an analog clock face with hour, minute, and second hands, updating every second.
//3. Create some way of switching between these two views.

class MainActivity : AppCompatActivity(R.layout.activity_main) {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(savedInstanceState == null){
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<DigitalClockFragment>(R.id.home_frament_container)
            }
        }
    }
}