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

        val matrix = ConvolutionMatrix()
        val config = arrayOf(
            doubleArrayOf(1.0, 2.0, 1.0),
            doubleArrayOf(2.0, 4.0, 2.0),
            doubleArrayOf(1.0, 2.0, 1.0)
        )
        matrix.applyConfig(config)
        matrix.Factor = 16
        matrix.Offset = 0
        return matrix.maps(bitmap)
    }
}