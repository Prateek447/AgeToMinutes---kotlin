package com.example.jokar.agetominutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var dateText : TextView
    lateinit var minTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dateText =  findViewById(R.id.selectedDate)
        minTextView = findViewById(R.id.convertInMin)

        button.setOnClickListener {view ->

            clickDatePicker(view)

            Toast.makeText(this,"Clicked",Toast.LENGTH_SHORT).show()
        }

        }

    fun clickDatePicker(view: View){
        val myCalendar =  Calendar.getInstance()
        val year =  myCalendar.get(Calendar.YEAR)
        val month =  myCalendar.get(Calendar.MONTH)
        val day =  myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, selectedYear, selectedMonth, selectedDayOfMonth ->

            val date =  "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
            dateText.setText(date)

            val sdf  =  SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            val theDate =  sdf.parse(date)
            //implement logic for convert date into minutes

            minTextView.setText(theDate.toString())


        },
            year,month,day
        ).show()
    }

}
