package com.pacomedina.uaa.editorimagenes.filtros

import com.pacomedina.uaa.editorimagenes.R

class FiltroNegativo : Filtro {

    override fun getNombre(): String {
        return "Negativo"
    }

    override fun getImagen(): Int {
        return R.drawable.negativo
    }

    override fun click() {
        println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAa")
    }
}