package com.realtomjoney.pyxlmoose.activities.canvas

import android.graphics.Bitmap
import com.realtomjoney.pyxlmoose.extensions.replacePixelsByColor

fun CanvasActivity.extendedOnColorToFindTapped(bitmap: Bitmap, colorToFind: Int): Bitmap {
    previewColorToFind = colorToFind

    val toReturn: Bitmap = if (previewColorToReplace != null) {
        val bmp = getCoverImageBitmap()
        bmp.replacePixelsByColor(previewColorToFind!!, previewColorToReplace!!)

        bmp
    } else {
        getCoverImageBitmap()
    }

    return toReturn
}