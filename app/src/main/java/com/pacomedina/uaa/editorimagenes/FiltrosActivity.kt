package com.pacomedina.uaa.editorimagenes

import android.Manifest
import android.annotation.SuppressLint
import android.app.Activity
import android.content.ContentValues
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Parcelable
import android.provider.MediaStore
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FiltrosActivity : AppCompatActivity() {

    private lateinit var btnRegresar: Button
    private lateinit var btnGuardar: Button
    private lateinit var imgFoto: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.filtros)

        var strUser: String? = intent.getStringExtra("imagen")

        btnRegresar = findViewById(R.id.btnRegresar)
        btnGuardar = findViewById(R.id.btnGuardar)
        imgFoto = findViewById(R.id.imgFoto)

        imgFoto.setImageURI(Uri.parse(strUser))

        btnRegresar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java));
        }
    }

}