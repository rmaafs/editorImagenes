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
//        val GaussianBlurConfig = arrayOf(
//            doubleArrayOf(1.0, 2.0, 1.0),
//            doubleArrayOf(2.0, 4.0, 2.0),
//            doubleArrayOf(1.0, 2.0, 1.0)
//        )
//        val convMatrix = ConvolutionMatrix(3)
//        convMatrix.applyConfig(GaussianBlurConfig)
//        convMatrix.Factor = 16.0
//        convMatrix.Offset = 0.0
//
//        return convMatrix.computeConvolution3x3(bitmap, convMatrix)

        val matrix = ConvolutionMatrix(3)
        val config = arrayOf(
            doubleArrayOf(1.0, 2.0, 1.0),
            doubleArrayOf(2.0, 4.0, 2.0),
            doubleArrayOf(1.0, 2.0, 1.0)
        )
        matrix.applyConfig(config)
        matrix.Factor = 16.0
        matrix.Offset = 0.0
        return matrix.computeConvolution3x3(bitmap, matrix)

//        val m = ConvolutionMatrix(3)
//        m.setAll(1)
//        m.Factor = 1 + 8
////        m.
//
//        return m.computeConvolution3x3(bitmap, m)

//        val oldBitmap = (img.getDrawable() as BitmapDrawable).bitmap
//        var picw : Int = oldBitmap.width
//        var pich : Int = oldBitmap.height
//
//        val bitmap : Bitmap = oldBitmap.copy(oldBitmap.config, true)
//        val pix = IntArray(picw * pich)
//        bitmap.getPixels(pix, 0, picw, 0, 0, picw, pich)
//
//        for (y in 0 until pich) {
//            for (x in 0 until picw) {
//                val index: Int = y * picw + x
//                var R = pix[index] shr 16 and 0xff
//                var G = pix[index] shr 8 and 0xff
//                var B = pix[index] and 0xff
//
//                R = procesar(R)
//                G = procesar(G)
//                B = procesar(B)
//
//                pix[index] = -0x1000000 or (R shl 16) or (G shl 8) or B
//            }
//        }
//
//        bitmap.setPixels(pix, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
//        return bitmap
    }

    private fun procesar(N: Int) : Int {
        val BRILLO = 50
        var nVal = (N + BRILLO)
        if (nVal < 0) nVal = 0
        if (nVal > 255) nVal = 255
        return nVal;
    }
}