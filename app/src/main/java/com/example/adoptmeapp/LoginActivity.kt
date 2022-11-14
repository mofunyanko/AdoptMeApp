package com.example.adoptmeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.Toolbar


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setTitle(R.string.btLogin)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        /* val etEmail = findViewById<EditText>(R.id.editTextEmail)
        val etPassword = findViewById<EditText>(R.id.editTextPassword)
        val btLogin = findViewById<Button>(R.id.btLogin)

        // ログインボタンが押された場合
        btLogin.setOnClickListener {
            // バリデーションチェックの結果
            val check = validationCheck(etEmail, etPassword)

            // エラーがない場合に画面を遷移
            if(check){
                val intent = Intent(this@LoginActivity, TopPageActivity::class.java)
                startActivity(intent)
            }
        } */
    }

    /* fun validationCheck(etEmail : EditText, etPassword : EditText) : Boolean{
        // メールアドレスの入力値がない場合
        if(etEmail.text.toString().isEmpty()){
            // メールアドレスの入力エリアをフォーカスさせる
            etEmail.requestFocus()
            // 画面の下にToastエラーメッセージを表示
            Toast.makeText(applicationContext, "メールアドレスを入力してください。", Toast.LENGTH_LONG).show()
            return false
        }

        //Passwordの入力値がない場合
        if(etPassword.text.toString().isEmpty()){
            // パスワードの入力エリアをフォーカスさせる
            etPassword.requestFocus()
            // 画面の下にToastエラーメッセージを表示
            Toast.makeText(applicationContext, "パスワードを入力してください。", Toast.LENGTH_LONG).show()
            return false
        }
        return true
    } */

    // ログインボタンが押された場合
    fun onLoginButtonClick(view: View?) {
        val intent = Intent(this@LoginActivity, TopPageActivity::class.java)
        startActivity(intent)
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