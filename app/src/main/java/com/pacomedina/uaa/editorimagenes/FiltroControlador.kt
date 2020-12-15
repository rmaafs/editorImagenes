package com.pacomedina.uaa.editorimagenes

import android.content.Context
import android.net.Uri
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView

class FiltroControlador : LinearLayout {

    private lateinit var txtTexto : TextView;
    private lateinit var imgFoto : ImageView;

    constructor(ctx: Context) : super(ctx) {
        inicializar();
    }

    constructor(ctx: Context, attrs: AttributeSet) : super(ctx, attrs) {
        inicializar();
    }

    constructor(ctx: Context, attrs: AttributeSet, defStyleAttr: Int) : super(ctx, attrs, defStyleAttr) {
        inicializar();
    }

    fun inicializar() {
        val li = LayoutInflater.from(context)
        li.inflate(R.layout.controlador, this, true)

        txtTexto = findViewById(R.id.txtTexto)
        imgFoto = findViewById(R.id.imgFoto)

        asignarEventos();
    }

    var listener : onClickFiltroListener? = null;
    fun setOnClickTeclaListener(aplicarFiltro: (String) -> Unit) {
        listener = object:onClickFiltroListener {
            override fun onClickFiltro(filtro: String) {
                aplicarFiltro(filtro)
            }
        }
    }

    fun asignarEventos() {
        imgFoto.setOnKeyListener(View.OnKeyListener { v, keyCode, event ->
            listener?.onClickFiltro(txtTexto.text.toString())
            false
        })
    }

    public fun setFiltro(uri: String, nombre: String) : LinearLayout {
        imgFoto.setImageURI(Uri.parse(uri))
        txtTexto.setText(nombre)
        return this
    }
}