package com.clearsky77.intent_20211102

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveToOther.setOnClickListener {
            val myIntent = Intent(this, OtherActivity::class.java)
                                // 어디서 출발, 어디로 도착
            startActivity(myIntent)
        }
    }
}