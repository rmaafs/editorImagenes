package com.pacomedina.uaa.editorimagenes.filtros

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.widget.ImageView
import com.pacomedina.uaa.editorimagenes.R

class FiltroSeparacionVerde : Filtro {

    override fun getNombre(): String {
        return "Separación verde"
    }

    override fun getImagen(): Int {
        return R.drawable.separacion_verde
    }

    override fun click(img: ImageView) : Bitmap {
        val oldBitmap = (img.getDrawable() as BitmapDrawable).bitmap
        var picw : Int = oldBitmap.width
        var pich : Int = oldBitmap.height

        val bitmap : Bitmap = oldBitmap.copy(oldBitmap.config, true)
        val pix = IntArray(picw * pich)
        bitmap.getPixels(pix, 0, picw, 0, 0, picw, pich)

        for (y in 0 until pich) {
            for (x in 0 until picw) {
                val index: Int = y * picw + x
                val R = pix[index] shr 16 and 0xff
                val G = pix[index] shr 8 and 0xff
                val B = pix[index] and 0xff

                pix[index] = -0x1000000 or (R shl 16) or (G shl 8) or B
            }
        }

        bitmap.setPixels(pix, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        return bitmap
    }
}