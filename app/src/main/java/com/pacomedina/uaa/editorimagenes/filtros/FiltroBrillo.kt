package com.pacomedina.uaa.editorimagenes.filtros

import com.pacomedina.uaa.editorimagenes.R

class FiltroBrillo : Filtro {

    override fun getNombre(): String {
        return "Brillo"
    }

    override fun getImagen(): Int {
        return R.drawable.brillo
    }

    override fun click() {
        println("HOLAAAAAAAAAAAAAAAAAAAAAAAAAAAAa")
    }
}