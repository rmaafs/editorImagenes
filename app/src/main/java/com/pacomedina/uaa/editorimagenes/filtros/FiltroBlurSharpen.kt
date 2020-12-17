package com.pacomedina.uaa.editorimagenes.filtros

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.widget.ImageView
import com.pacomedina.uaa.editorimagenes.R

class FiltroBlurSharpen : Filtro {

    override fun getNombre(): String {
        return "Sharpen"
    }

    override fun getImagen(): Int {
        return R.drawable.blur_gaussian
    }

    override fun click(img: ImageView) : Bitmap {
        val oldBitmap = (img.getDrawable() as BitmapDrawable).bitmap
        val bitmap : Bitmap = oldBitmap.copy(oldBitmap.config, true)

        val matrix = ConvolucionMatriz()
        val config = arrayOf(
            intArrayOf(0, -2, 0),
            intArrayOf(-2, 11, -2),
            intArrayOf(0, -2, 0)
        )
        matrix.setMatriz(config)
        matrix.Factor = 3
        matrix.Offset = 0
        return matrix.convolucion(bitmap)
    }
}