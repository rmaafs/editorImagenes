package com.pacomedina.uaa.editorimagenes

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity


class FiltrosActivity : AppCompatActivity() {

    private lateinit var btnRegresar: Button
    private lateinit var btnGuardar: Button
    private lateinit var imgFoto: ImageView
    private lateinit var layoutContainer : LinearLayout;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.filtros)

        var strUser: String? = intent.getStringExtra("imagen")

        btnRegresar = findViewById(R.id.btnRegresar)
        btnGuardar = findViewById(R.id.btnGuardar)
        imgFoto = findViewById(R.id.imgFoto)
        layoutContainer = findViewById(R.id.layoutContainer)

        imgFoto.setImageURI(Uri.parse(strUser))

        btnRegresar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java));
        }


        val filtro1 = FiltroControlador(this)
        filtro1.setFiltro("asd", "Positivo")

        layoutContainer.addView(filtro1)

        layoutContainer.addView(FiltroControlador(this).setFiltro("asd", "Negativo"))
    }

}