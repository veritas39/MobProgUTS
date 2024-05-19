package com.example.pnj.uts.ti.muhammad_bryan

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment

class fragmentHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragmenthomee)

        val btnHome = findViewById<Button>(R.id.btnHome)
        val btnBerita = findViewById<Button>(R.id.btnBerita)
        val btnProfile = findViewById<Button>(R.id.btnProfile)

        replaceFragment(Fragment_Home())

        btnHome.setOnClickListener {
            replaceFragment(Fragment_Home())
        }
        btnBerita.setOnClickListener {
            replaceFragment(Fragment_Berita())
        }
        btnProfile.setOnClickListener {
            replaceFragment(Fragment_Profile())
        }

        val btnMenu = findViewById<Button>(R.id.btnMenu)

        val btnTambahData = findViewById<Button>(R.id.btnTambahData)
        val btnDataAlumni = findViewById<Button>(R.id.btnDataAlumni)
        val btnLogout = findViewById<Button>(R.id.btnLogout)

        btnMenu.setOnClickListener {
            if (btnTambahData.visibility == View.VISIBLE) {
                btnTambahData.visibility = View.GONE
                btnDataAlumni.visibility = View.GONE
                btnLogout.visibility = View.GONE
            } else {
                btnTambahData.visibility = View.VISIBLE
                btnDataAlumni.visibility = View.VISIBLE
                btnLogout.visibility = View.VISIBLE
            }

        }

        btnTambahData.setOnClickListener {
            val intent = Intent(this, tambahDataPage::class.java)
            startActivity(intent)
            finish()
        }


    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container,fragment)
            .commit()
    }

    fun tryClick(){
        val toast = Toast.makeText(this, "email atau password salah", Toast.LENGTH_SHORT)
        toast.show()
    }


}