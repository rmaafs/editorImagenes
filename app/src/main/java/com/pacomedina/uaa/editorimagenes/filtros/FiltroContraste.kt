package com.pacomedina.uaa.editorimagenes.filtros

import com.pacomedina.uaa.editorimagenes.R

class FiltroContraste : Filtro {

    override fun getNombre(): String {
        return "Contraste"
    }

    override fun getImagen(): Int {
        return R.drawable.contraste
    }

    override fun click() {
        println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAa")
    }
}