package com.example.adoptmeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar

class LoginActivity : AppCompatActivity() {
    // データベースヘルパーオブジェクト
    private val _helper = DatabaseHelper(this@LoginActivity)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setTitle(R.string.btLogin)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onDestroy() {
        // ヘルパーオブジェクトの解放
        _helper.close()
        super.onDestroy()
    }

    // ログインボタンが押された場合
    fun onLoginButtonClick(view: View?) {
        val email = findViewById<EditText>(R.id.editEmail)
        val password = findViewById<EditText>(R.id.editPassword)
        val db = _helper.readableDatabase
        val name: String
        var args = listOf(email.text.toString(), password.text.toString()).toTypedArray()
        var result = db.rawQuery("SELECT * FROM users WHERE email_address = ? AND password = ?", args)
        if (result.moveToNext()) {
            val intent = Intent(this@LoginActivity, TopPageActivity::class.java)
            name = result.getString(result.getColumnIndex("name"))
            intent.putExtra("userName", name)
            startActivity(intent)
        }
        else {
            Toast.makeText(this@LoginActivity,"メールアドレスまたはパスワードが間違っています", Toast.LENGTH_LONG).show()
        }
    }

    // 戻るボタンが押された場合
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var returnVal = true

        if(item.itemId == android.R.id.home) {
            finish()
        }
        else {
            returnVal = super.onOptionsItemSelected(item)
        }
        return returnVal
    }
}