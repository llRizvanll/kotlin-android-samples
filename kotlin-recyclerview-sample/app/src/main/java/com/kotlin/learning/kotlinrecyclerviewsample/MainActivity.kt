package com.kotlin.learning.kotlinrecyclerviewsample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kotlin.learning.kotlinrecyclerviewsample.adapter.UserAdapter
import com.kotlin.learning.kotlinrecyclerviewsample.model.UserData

class MainActivity : AppCompatActivity() {

    private var recyclerView : RecyclerView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.list_view)

        //add adapter
        var listAdapter = UserAdapter(generateData())
        val layourManager = LinearLayoutManager(applicationContext)
        recyclerView?.layoutManager = layourManager
        recyclerView?.itemAnimator = DefaultItemAnimator()

        recyclerView?.adapter = listAdapter
        listAdapter.notifyDataSetChanged()


    }

    private fun generateData(): ArrayList<UserData> {
        var resultData = ArrayList<UserData>()

        for (i in 0..9){
            val userItem  = UserData("Kotlin","India")
            resultData.add(userItem)
        }
        return resultData
    }
}
