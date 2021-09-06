package com.example.tasbeehhistory

import android.content.Context

class SharedPref {
    private var sep: String? = null
    fun setCount(c: Context, count: String?): Boolean {
        val pref = c.getSharedPreferences(
            "MyPrefs",
            Context.MODE_PRIVATE
        ) //"MODE_PRIVATE" because  shared pref would only be access able to this app, no other app would access it
        val editor =
            pref.edit() //now editor is created of this preferences, and by using it we can store these var i.e username and pwd
        editor.putString(count_history, count)
        return editor.commit() // returning boolean val, either modification done successfully or not
    }

    fun getCount(c: Context): String? {
        val pref = c.getSharedPreferences(
            "MyPrefs",
            Context.MODE_PRIVATE
        ) //"MODE_PRIVATE" because  shared pref would only be access able to this app, no other app would access it
        sep = pref.getString(count_history, "")
        return sep
    }

    companion object {
        const val count_history = "COUNTER_HISTORY"
    }
}