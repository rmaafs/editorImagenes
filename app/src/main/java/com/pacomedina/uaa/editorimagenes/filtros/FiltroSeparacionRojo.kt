package com.pacomedina.uaa.editorimagenes.filtros

import com.pacomedina.uaa.editorimagenes.R

class FiltroSeparacionRojo : Filtro {

    override fun getNombre(): String {
        return "Separación rojo"
    }

    override fun getImagen(): Int {
        return R.drawable.separacion_rojo
    }

    override fun click() {
        println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAa")
    }
}