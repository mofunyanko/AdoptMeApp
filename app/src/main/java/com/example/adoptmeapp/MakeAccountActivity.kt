package com.example.adoptmeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.widget.Toolbar

class MakeAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_make_account)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setTitle(R.string.btMakeAccount)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
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