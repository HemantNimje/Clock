package com.hemant.clock

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*

class DigitalClockFragment : Fragment() {

    val clockViewModel = ClockViewModel()
    lateinit var clockTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_digital, container, false)
        clockTextView = view.findViewById(R.id.text_clock_digital)

        return view
    }

    override fun onResume() {
        super.onResume()

        initializeObservers()
    }

    /**
     * Initializes observers for the UI layer
     */
    fun initializeObservers() {
        clockViewModel.getClockLiveData().observe(viewLifecycleOwner, Observer {
            clockTextView.setText(createTimeString(it))
        })
    }

    fun createTimeString(timeInMilliseconds: Long) : String {
        // 11:59:01 PM
        val pattern = "HH:mm:ss aa"
        val simpleDateFormat = SimpleDateFormat(pattern)
        val date = simpleDateFormat.format(Date(timeInMilliseconds))
        return date.toString()
    }
}