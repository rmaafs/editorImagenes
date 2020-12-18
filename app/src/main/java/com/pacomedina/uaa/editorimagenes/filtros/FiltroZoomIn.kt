package com.pacomedina.uaa.editorimagenes.filtros

import android.graphics.Bitmap
import android.graphics.drawable.BitmapDrawable
import android.widget.ImageView
import com.pacomedina.uaa.editorimagenes.R


class FiltroZoomIn : Filtro {

    override fun getNombre(): String {
        return "Zoom +"
    }

    override fun getImagen(): Int {
        return R.drawable.blur_gaussian
    }

    override fun click(img: ImageView) : Bitmap {
        val oldBitmap = (img.getDrawable() as BitmapDrawable).bitmap
        var picw : Int = oldBitmap.width
        var pich : Int = oldBitmap.height

        val scaleFactor = 0.75 // Set this to the zoom factor

        val widthOffset = ((1 - scaleFactor) / 2 * picw).toInt()
        val heightOffset = ((1 - scaleFactor) / 2 * pich).toInt()
        val numWidthPixels: Int = picw - 2 * widthOffset
        val numHeightPixels: Int = pich - 2 * heightOffset

        return Bitmap.createBitmap(
            oldBitmap,
            widthOffset,
            heightOffset,
            numWidthPixels,
            numHeightPixels,
            null,
            true
        )
    }

    fun scaleDown(
        realImage: Bitmap, maxImageSize: Float,
        filter: Boolean
    ): Bitmap {
        val ratio = Math.min(
            maxImageSize / realImage.width,
            maxImageSize / realImage.height
        )
        val width = Math.round(ratio * realImage.width)
        val height = Math.round(ratio * realImage.height)
        return Bitmap.createScaledBitmap(
            realImage, width,
            height, filter
        )
    }
}