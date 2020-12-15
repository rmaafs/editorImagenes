package com.pacomedina.uaa.editorimagenes.filtros

import com.pacomedina.uaa.editorimagenes.R

class FiltroSeparacionVerde : Filtro {

    override fun getNombre(): String {
        return "Separación verde"
    }

    override fun getImagen(): Int {
        return R.drawable.separacion_verde
    }

    override fun click() {
        println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAa")
    }
}