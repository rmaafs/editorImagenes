package com.pacomedina.uaa.editorimagenes.filtros

import com.pacomedina.uaa.editorimagenes.R

class FiltroGrises : Filtro {

    override fun getNombre(): String {
        return "Grises"
    }

    override fun getImagen(): Int {
        return R.drawable.grises
    }

    override fun click() {
        println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAa")
    }
}