package com.example.pnj.uts.ti.muhammad_bryan

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper(context: Context, dbName: String, version: Int) : SQLiteOpenHelper(context, dbName, null, version) {

    override fun onCreate(db: SQLiteDatabase) {
        db.execSQL("CREATE TABLE IF NOT EXISTS data_alumni (id INTEGER PRIMARY KEY AUTOINCREMENT, nim TEXT, nama_alumni TEXT, tempat_lahir TEXT, tanggal_lahir TEXT, alamat TEXT, agama TEXT, telepon TEXT, tahun_masuk TEXT, tahun_lulus TEXT, pekerjaan TEXT, jabatan TEXT)")
    }

    // Other methods for upgrading database (if needed)
    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        // Handle database schema changes here
    }
}
