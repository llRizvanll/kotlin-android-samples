package com.kotlin.learning.databinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.kotlin.learning.databinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val binding : ActivityMainBinding = DataBindingUtil.
                setContentView(this,R.layout.activity_main)
        val user = User("Kotlin",4,"kotlin@intellij.com")
        binding.setVariable(BR.user,user)

    }
}
