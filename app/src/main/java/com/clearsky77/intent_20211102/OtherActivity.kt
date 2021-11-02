package com.clearsky77.intent_20211102

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_other.*

class OtherActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        btnReturnToMain.setOnClickListener {
//            아래는 화면이 쌓이는 문제가 생김
//            val myIntent = Intent(this, MainActivity::class.java)
//            // 어디서 출발, 어디로 도착
//            startActivity(myIntent)

//            화면 종료 처리 해주기
          finish()
        }
    }
}