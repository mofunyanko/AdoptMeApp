package com.example.adoptmeapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.webkit.WebView
import androidx.appcompat.widget.Toolbar

class ViewDetailsActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_details)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setTitle(R.string.nav_item_event_announcement)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // Webサイトをアプリ内で表示
        val webView: WebView = findViewById(R.id.webView)
        // Javascriptを有効化
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("https://www.kanazawa-it.ac.jp/gakubu_daigakuin/kogaku/joho/index.html")
    }

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