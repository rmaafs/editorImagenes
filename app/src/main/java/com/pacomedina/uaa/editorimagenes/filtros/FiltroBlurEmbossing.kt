package com.pacomedina.uaa.editorimagenes.filtros

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.widget.ImageView
import com.pacomedina.uaa.editorimagenes.R

class FiltroBlurEmbossing : Filtro {

    override fun getNombre(): String {
        return "Embossing"
    }

    override fun getImagen(): Int {
        return R.drawable.emboosing
    }

    override fun click(img: ImageView) : Bitmap {
        val oldBitmap = (img.getDrawable() as BitmapDrawable).bitmap
        val bitmap : Bitmap = oldBitmap.copy(oldBitmap.config, true)

//        val matrix = ConvolutionMatrix(3)
//        val config = arrayOf(
//            intArrayOf(-1, 0, -1),
//            intArrayOf(0, 4, 0),
//            intArrayOf(-1, 0, -1)
//        )
//        matrix.applyConfig(config)
//        matrix.Factor = 1
//        matrix.Offset = 127
//        return matrix.computeConvolution3x3(bitmap, matrix)

        val matrix = ConvolucionMatriz()
        val config = arrayOf(
            intArrayOf(-1, 0, -1),
            intArrayOf(0, 4, 0),
            intArrayOf(-1, 0, -1)
        )
        matrix.setMatriz(config)
        matrix.Factor = 1
        matrix.Offset = 127
        return matrix.convolucion(bitmap)
    }
}