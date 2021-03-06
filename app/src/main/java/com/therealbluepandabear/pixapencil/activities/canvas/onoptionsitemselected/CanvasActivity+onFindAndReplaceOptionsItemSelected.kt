package com.therealbluepandabear.pixapencil.activities.canvas.onoptionsitemselected

import androidx.fragment.app.commit
import com.therealbluepandabear.pixapencil.R
import com.therealbluepandabear.pixapencil.activities.canvas.CanvasActivity
import com.therealbluepandabear.pixapencil.activities.canvas.canvashelpers.drawPixelGridViewBitmap
import com.therealbluepandabear.pixapencil.activities.canvas.canvashelpers.drawTransparentBackgroundViewBitmap
import com.therealbluepandabear.pixapencil.activities.canvas.selectedColorPaletteIndex
import com.therealbluepandabear.pixapencil.enums.SnackbarDuration
import com.therealbluepandabear.pixapencil.extensions.getColors
import com.therealbluepandabear.pixapencil.extensions.showSnackbar
//import com.therealbluepandabear.pixapencil.fragments.canvas.pixelGridViewInstance
import com.therealbluepandabear.pixapencil.fragments.replacecolor.ReplaceColorFragment

fun CanvasActivity.onFindAndReplaceOptionsItemSelected() {
    val uniqueColors = binding.activityCanvasPixelGridView.pixelGridViewBitmap.getColors()

    if (uniqueColors.isNotEmpty()) {
        supportFragmentManager.commit {
            replace(
                R.id.activityCanvas_primaryFragmentHost, ReplaceColorFragment.newInstance(
                    paramCanvasColors = uniqueColors,
                    paramPixelGridViewBitmapSource = drawPixelGridViewBitmap(),
                    paramTransparentBitmapSource = drawTransparentBackgroundViewBitmap(),
                    paramSelectedColorPaletteIndex = selectedColorPaletteIndex,
                    paramScaledWidth = binding.activityCanvasPixelGridView.measuredWidth,
                    paramScaledHeight = binding.activityCanvasPixelGridView.measuredHeight
                ))
            addToBackStack(null)
        }
    } else {
        binding.activityCanvasCoordinatorLayout.showSnackbar(
            getString(R.string.snackbar_find_and_replace_warning),
            SnackbarDuration.Default)
    }
}