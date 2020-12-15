package com.pacomedina.uaa.editorimagenes.filtros

import com.pacomedina.uaa.editorimagenes.R

class FiltroGamma : Filtro {

    override fun getNombre(): String {
        return "Gamma"
    }

    override fun getImagen(): Int {
        return R.drawable.gamma
    }

    override fun click() {
        println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAa")
    }
}