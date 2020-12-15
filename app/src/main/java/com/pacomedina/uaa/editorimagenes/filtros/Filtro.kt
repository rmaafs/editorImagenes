package com.pacomedina.uaa.editorimagenes.filtros

interface Filtro {
    fun click()
    fun getImagen() : Int
    fun getNombre() : String
}