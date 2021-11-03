package com.clearsky77.intent_20211102

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val REQ_CODE_FOR_NICKNAME = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnMoveToOther.setOnClickListener {
            val myIntent = Intent(this, OtherActivity::class.java)
                                // 어디서 출발, 어디로 도착
            startActivity(myIntent)
        }

        btnSendMessage.setOnClickListener {
            val inputMessage = edtMessage.text.toString()
            val myIntent = Intent(this, OtherActivity::class.java)
            myIntent.putExtra("message", inputMessage) // 필요 데이터 첨부
            startActivity(myIntent)
        }

//        닉네임 변경 클릭시
        btnEditNickname.setOnClickListener {
            val inputMessage = edtMessage.text.toString()
            val myIntent = Intent(this, EditNicknameActivity::class.java)
            myIntent.putExtra("message", inputMessage) // 필요 데이터 첨부
            startActivityForResult(myIntent, REQ_CODE_FOR_NICKNAME)
            //                      목적지, 어느 데이터를 받아올 것이다.
        }

//        안드로이드 전화 화면 (DAIL)
        btnDial.setOnClickListener {
            val inputPhoneNum = edtPhoneNum.text.toString()
            val myUri = Uri.parse("tel:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_DIAL, myUri)
            startActivity(myIntent)
        }
//        안드로이드 전화 화면 (CALL)
        btnCall.setOnClickListener {
            val inputPhoneNum = edtPhoneNum.text.toString()
            val myUri = Uri.parse("tel:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_CALL, myUri)
            startActivity(myIntent)
        }
//        안드로이드 문자 보내기 (SANDTO)
        btnSms.setOnClickListener {
            val inputPhoneNum = edtPhoneNum.text.toString()
            val myUri = Uri.parse("smsto:${inputPhoneNum}")
            val myIntent = Intent(Intent.ACTION_SENDTO, myUri)

            myIntent.putExtra("sms_body","지금 Clearsky77의 MyCharacter를 다운 받으세요!")

            startActivity(myIntent)
        }

//        안드로이드 web 띄우기 (VIEW)
        btnWebpage.setOnClickListener {
            val myUri = Uri.parse("https://www.ff14.co.kr/main/")
            val myIntent = Intent( Intent.ACTION_VIEW, myUri )
            startActivity(myIntent)
        }

//        안드로이트 마켓 띄우기
        btnKakaoStore.setOnClickListener {
            val myUri = Uri.parse("market://details?id=com.kakao.talk")
            val myIntent = Intent( Intent.ACTION_VIEW, myUri )
            startActivity(myIntent)
        }


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        Log.d("메인화면", "결과를 받아오면 무조건 실행됨") // 확인 버튼이든 뒤로 버튼이든 무조건 실행
        Log.d("메인화면", requestCode.toString()) // 확인 버튼이든 뒤로 버튼이든 무조건 실행

        if(requestCode == REQ_CODE_FOR_NICKNAME){
            if(resultCode == RESULT_OK){
                val newNickname = data?.getStringExtra("nick")
                txtNickname.text = newNickname
            }
        }

    }


}