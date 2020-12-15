package com.pacomedina.uaa.editorimagenes

import android.content.Intent
import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.pacomedina.uaa.editorimagenes.filtros.*


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

        val bitmapOriginal : Bitmap = (imgFoto.getDrawable() as BitmapDrawable).bitmap.copy((imgFoto.getDrawable() as BitmapDrawable).bitmap.config, true)

        btnRegresar.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java));
        }

        var filtros = arrayOf(FiltroControlador(this).setFiltro(FiltroNegativo()),
            FiltroControlador(this).setFiltro(FiltroGrises()),
            FiltroControlador(this).setFiltro(FiltroBrillo()),
            FiltroControlador(this).setFiltro(FiltroContraste()),
            FiltroControlador(this).setFiltro(FiltroGamma()),
            FiltroControlador(this).setFiltro(FiltroSeparacionRojo()),
            FiltroControlador(this).setFiltro(FiltroSeparacionVerde()),
            FiltroControlador(this).setFiltro(FiltroSeparacionAzul())
            )

        for (filtro in filtros) {
            layoutContainer.addView(filtro.getLayout())
            filtro.setOnClickFiltroListener {
                Toast.makeText(this, "Filtro ${it} aplicado", Toast.LENGTH_SHORT).show()

                imgFoto.setImageBitmap(bitmapOriginal)
                imgFoto.setImageBitmap(filtro.convertImg(imgFoto))
            }
        }

    }

}