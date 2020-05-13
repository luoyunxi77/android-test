package com.example.android_test

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_banner.*

class BannerActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_banner)

        banner_detail.setOnClickListener {
            val intent = Intent()
            intent.putExtra("Result", "奥秘不得而知")
            setResult(8888, intent)
            finish()
        }

    }
}