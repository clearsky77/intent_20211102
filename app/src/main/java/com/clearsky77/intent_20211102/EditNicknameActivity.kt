package com.clearsky77.intent_20211102

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_edit_nickname.*

class EditNicknameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_nickname)

        btnOK.setOnClickListener {
            val inputNickname = edtNickname.text.toString()

            val resultIntent = Intent() // 왕복이라 출발지, 목적지를 명시할 필요가 없다!
            resultIntent.putExtra("nick",inputNickname)
            setResult(RESULT_OK, resultIntent)
            // 확이 누름, 들고 돌아갈 데이터
            finish() // 이전 화면으로 돌아간다.
        }
    }
}