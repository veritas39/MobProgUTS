package com.example.pnj.uts.ti.muhammad_bryan

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class tambahDataPage: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tambahdatapagee)

        val btnMenu = findViewById<Button>(R.id.btnMenu)

        btnMenu.setOnClickListener {
            val intent = Intent(this, fragmentHome::class.java)
            startActivity(intent)
            finish()

        }

        val nimEditText = findViewById<EditText>(R.id.nimEditText)
        val namaAlumniEditText = findViewById<EditText>(R.id.namaAlumniEditText)
        val tempatLahirEditText = findViewById<EditText>(R.id.tempatLahirEditText)
        val tanggalLahirEditText = findViewById<EditText>(R.id.tanggalLahirEditText)
        val alamatEditText = findViewById<EditText>(R.id.alamatEditText)
        val agamaEditText = findViewById<EditText>(R.id.agamaEditText)
        val teleponEditText = findViewById<EditText>(R.id.teleponEditText)
        val tahunMasukEditText = findViewById<EditText>(R.id.tahunMasukEditText)
        val tahunLulusEditText = findViewById<EditText>(R.id.tahunLulusEditText)
        val pekerjaanEditText = findViewById<EditText>(R.id.pekerjaanEditText)
        val jabatanEditText = findViewById<EditText>(R.id.jabatanEditText)

        val submitButton = findViewById<Button>(R.id.submitButton)
        submitButton.setOnClickListener {
            val nim = nimEditText.text.toString()
            val namaAlumni = namaAlumniEditText.text.toString()
            val tempatLahir = tempatLahirEditText.text.toString()
            val tanggalLahir = tanggalLahirEditText.text.toString()
            val alamat = alamatEditText.text.toString()
            val agama = agamaEditText.text.toString()
            val telepon = teleponEditText.text.toString()
            val tahunMasuk = tahunMasukEditText.text.toString()
            val tahunLulus = tahunLulusEditText.text.toString()
            val pekerjaan = pekerjaanEditText.text.toString()
            val jabatan = jabatanEditText.text.toString()

            // Call function to insert data
            insertData(nim, namaAlumni, tempatLahir, tanggalLahir, alamat, agama, telepon, tahunMasuk, tahunLulus, pekerjaan, jabatan)
        }
    }

    fun insertData(nim: String, namaAlumni: String, tempatLahir: String, tanggalLahir: String, alamat: String, agama: String, telepon: String, tahunMasuk: String, tahunLulus: String, pekerjaan: String, jabatan: String) {
        val dbHelper = DBHelper(this, "myDatabase.db", 1) // Context, database name, version
        val db = dbHelper.writableDatabase

        val contentValues = ContentValues()
        contentValues.put("nim", nim)
        contentValues.put("nama_alumni", namaAlumni)
        contentValues.put("tempat_lahir", tempatLahir)
        contentValues.put("tanggal_lahir", tanggalLahir)
        contentValues.put("alamat", alamat)
        contentValues.put("agama", agama)
        contentValues.put("telepon", telepon)
        contentValues.put("tahun_masuk", tahunMasuk)
        contentValues.put("tahun_lulus", tahunLulus)
        contentValues.put("pekerjaan", pekerjaan)
        contentValues.put("jabatan", jabatan)

        val rowId = db.insert("data_alumni", null, contentValues)

        if (rowId != -1L) {
            val toast = Toast.makeText(this, "Data berhasil disimpan!", Toast.LENGTH_SHORT)
            toast.show()
        } else {
            val toast = Toast.makeText(this, "Data gagal disimpan", Toast.LENGTH_SHORT)
            toast.show()
        }

        db.close()
    }
}