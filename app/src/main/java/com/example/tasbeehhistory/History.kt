package com.example.tasbeehhistory

import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import com.example.tasbeehhistory.databinding.ActivityHistoryBinding
import java.util.*

class History : AppCompatActivity() {

  private var separated: List<String> = ArrayList()
    private var array: MutableList<String> = ArrayList()
    var count: String? = null
    var inc = 0
    private lateinit var binding: ActivityHistoryBinding
    //each activity will have its own binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupToolbar()

        val pref = SharedPref()
        count = pref.getCount(this@History)
        // separated.count.split(";"));
        separated = ArrayList(listOf(*count!!.split(";").toTypedArray()))
        for (i in separated.indices) {
            inc++
            Log.d("MyApp", "item " + inc + separated[i])
            array.add(i, "Count " + inc + ") " + separated[i])
        }
        val adapter: ArrayAdapter<*> =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, array)
        binding.listView.adapter = adapter
    }

    private fun setupToolbar()
    {
        setSupportActionBar(binding.customToolBar.root)
        //root is the main layout of the xml file , in this case it is Relative Layout
    }
}
