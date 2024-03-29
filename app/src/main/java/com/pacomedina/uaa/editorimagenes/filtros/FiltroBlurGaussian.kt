package com.pacomedina.uaa.editorimagenes.filtros

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.widget.ImageView
import com.pacomedina.uaa.editorimagenes.R

class FiltroBlurGaussian : Filtro {

    override fun getNombre(): String {
        return "Gaussian Blur"
    }

    override fun getImagen(): Int {
        return R.drawable.blur_gaussian
    }

    override fun click(img: ImageView) : Bitmap {
        val oldBitmap = (img.getDrawable() as BitmapDrawable).bitmap
        val bitmap : Bitmap = oldBitmap.copy(oldBitmap.config, true)

        val matrix = ConvolucionMatriz()
        val config = arrayOf(
            intArrayOf(1, 2, 1),
            intArrayOf(2, 4, 2),
            intArrayOf(1, 2, 1)
        )
        matrix.setMatriz(config)
        matrix.Factor = 16
        matrix.Offset = 0
        return matrix.convolucion(bitmap)
    }
}