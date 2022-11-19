package com.example.adoptmeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.viewpager2.widget.ViewPager2
import com.example.adoptmeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    // ログインボタンが押された場合
    fun onLoginButtonClick(view: View?) {
        val intent = Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(intent)
    }

    // 新規登録ボタンが押された場合
    fun onMakeAccountButtonClick(view: View?) {
        val intent = Intent(this@MainActivity, MakeAccountActivity::class.java)
        startActivity(intent)
    }
}