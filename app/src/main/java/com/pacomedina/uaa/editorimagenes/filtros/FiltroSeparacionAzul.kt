package com.pacomedina.uaa.editorimagenes.filtros

import com.pacomedina.uaa.editorimagenes.R

class FiltroSeparacionAzul : Filtro {

    override fun getNombre(): String {
        return "Separación azul"
    }

    override fun getImagen(): Int {
        return R.drawable.separacion_azul
    }

    override fun click() {
        println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAa")
    }
}