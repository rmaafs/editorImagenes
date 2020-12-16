package com.pacomedina.uaa.editorimagenes.filtros

import android.graphics.Bitmap
import android.graphics.Color
import android.graphics.drawable.BitmapDrawable
import android.widget.ImageView
import com.pacomedina.uaa.editorimagenes.R

class FiltroSeparacionPixeleado : Filtro {

    override fun getNombre(): String {
        return "Pixeleado"
    }

    override fun getImagen(): Int {
        return R.drawable.pantalla_rota
    }

    override fun click(img: ImageView) : Bitmap {
        val oldBitmap = (img.getDrawable() as BitmapDrawable).bitmap
        var picw : Int = oldBitmap.width
        var pich : Int = oldBitmap.height

        val bitmap : Bitmap = oldBitmap.copy(oldBitmap.config, true)
        val pix = IntArray(picw * pich)
        bitmap.getPixels(pix, 0, picw, 0, 0, picw, pich)

        var preR = 0
        var preG = 0
        var preB = 0

        val sizePixel = 90

        for (y in 0 until pich) {
            for (x in 0 until picw) {
                val index: Int = y * picw + x
                var R = pix[index] shr 16 and 0xff
                var G = pix[index] shr 8 and 0xff
                var B = pix[index] and 0xff

                if ((y % sizePixel == 1 || x % sizePixel == 0) || (preR == preG && preG == preB && preB == 0)) {
                    preR = pix[index] shr 16 and 0xff
                    preG = pix[index] shr 8 and 0xff
                    preB = pix[index] and 0xff
                }

                pix[index] = -0x1000000 or (preR shl 16) or (preG shl 8) or preB
            }
        }

        bitmap.setPixels(pix, 0, bitmap.getWidth(), 0, 0, bitmap.getWidth(), bitmap.getHeight());
        return bitmap
    }
}