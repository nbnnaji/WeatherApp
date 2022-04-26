package com.nkechinnaji.designpatterns

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val soundText = findViewById<TextView>(R.id.sound_txt)
        val flightText = findViewById<TextView>(R.id.flight_txt)
        val mallard: Duck = MallardDuck()
        mallard.performQuack()
        mallard.performFly()
        Log.d("QUACK", "\${mallard.performQuack()}")
    }
}