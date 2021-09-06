package com.example.tasbeehhistory

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.tasbeehhistory.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private var counter = 0
    var sep: String? = null
    var obj = SharedPref()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.historyBtn2.setOnClickListener {
            val obj = Intent(this@MainActivity, History::class.java)
            startActivity(obj)
        }
        binding.resetBtn.setOnClickListener {
            sep = if (sep!!.isEmpty()) {
                "" + counter
            } else {
                "$sep;$counter"
            }
            if (obj.setCount(this@MainActivity, sep)) {
                Toast.makeText(this@MainActivity, "count saved!", Toast.LENGTH_SHORT).show()
                // historyCount++; //It is basically used as index for storing counters values in historyArr..
                // each time we store val in array we increment this variable so that next time when the value will be stored it'll have a new index in array
                counter = 0 //resetting the counter back to when this(reset) button gets clicked
                binding.counterTxt.text = "" + counter
            }
        }
        binding.countBtn.setOnClickListener {
            counter++ //incrementing the counter when this(count) button gets clicked
            binding.counterTxt.text = "" + counter

        }

        sep = ""


    }


}