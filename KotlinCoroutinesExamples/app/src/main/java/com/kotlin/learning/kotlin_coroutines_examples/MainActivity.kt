package com.kotlin.learning.kotlin_coroutines_examples

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private val RESULT_1 = "result#1"
    private val RESULT_2 = "result#2"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            CoroutineScope(IO).launch{
                getDummyApiResults()
            }
        }
    }

    private suspend fun getDummyApiResults(){
        val result1 = getApiResults1()
        println("debug : $result1")
        setNewTextonMainThread(result1)

        val result2 = getApiResults2()
        println("debug : $result2")
        setNewTextonMainThread(result2)
    }

    private fun setNewText(inputText : String ) {
        val newText = text.text.toString() + "\n$inputText"
        text.text = newText
    }

    private suspend fun setNewTextonMainThread(newText : String) {
        withContext(Main){
            setNewText(newText)
        }
    }

    private suspend fun getApiResults1() : String {
        logThread("getApiResults1")
        delay(1000)
        return RESULT_1
    }

    private suspend fun getApiResults2() : String {
        logThread("getApiResults2")
        delay(1000)
        return RESULT_2
    }

    private fun logThread(methodName : String){
        println("debug : ${methodName} : ${Thread.currentThread().name}")
    }
}
