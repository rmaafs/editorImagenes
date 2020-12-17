package com.pacomedina.uaa.editorimagenes.filtros

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.widget.ImageView
import com.pacomedina.uaa.editorimagenes.R

class FiltroBlurEdgeDetection : Filtro {

    override fun getNombre(): String {
        return "Edge detection"
    }

    override fun getImagen(): Int {
        return R.drawable.edge_detection
    }

    override fun click(img: ImageView) : Bitmap {
        val oldBitmap = (img.getDrawable() as BitmapDrawable).bitmap
        val bitmap : Bitmap = oldBitmap.copy(oldBitmap.config, true)

        val convolucion = ConvolucionMatriz()
        val array = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(0, 0, 0),
            intArrayOf(-1, -1, -1)
        )
        convolucion.setMatriz(array)
        convolucion.Factor = 1
        convolucion.Offset = 127
        return convolucion.convolucion(bitmap)

//        val matrix = ConvolutionMatrix(3)
//        val config = arrayOf(
//            intArrayOf(1, 1, 1),
//            intArrayOf(0, 0, 0),
//            intArrayOf(-1, -1, -1)
//        )
//        matrix.applyConfig(config)
//        matrix.Factor = 1
//        matrix.Offset = 127
//        return matrix.computeConvolution3x3(bitmap, matrix)
    }
}