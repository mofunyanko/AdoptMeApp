package com.example.adoptmeapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context): SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    companion object {
        private const val DATABASE_NAME = "user.db"
        private const val DATABASE_VERSION = 1
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val sb = StringBuilder()
        sb.append("CREATE TABLE users (")
        sb.append("_id INTEGER PRIMARY KEY,")
        sb.append("name TEXT,")
        sb.append("birthday TEXT,")
        sb.append("phone_num INTEGER,")
        sb.append("email_address TEXT,")
        sb.append("address TEXT,")
        sb.append("job TEXT,")
        sb.append("password TEXT")
        sb.append(");")
        val sql = sb.toString()

        // nullは許容しない
        db!!.execSQL(sql)

        val qry1 = arrayOf(
            "INSERT INTO users(name, birthday, phone_num, email_address, address, job, password) VALUES ('岩崎美穂', '2000-01-11', 0123456789, 'test1@gmail.com', '石川県野々市市', '学生', 'test1_password')",
            "INSERT INTO users(name, birthday, phone_num, email_address, address, job, password) VALUES ('test2', '2000-11-21', 9876543210, 'test2@gmail.com', '石川県金沢市', 'エンジニア', 'test2_password')"
        )
        for (q in qry1) {
            db.execSQL(q)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) { }
}