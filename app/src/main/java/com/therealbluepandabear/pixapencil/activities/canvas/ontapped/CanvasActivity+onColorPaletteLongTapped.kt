package com.therealbluepandabear.pixapencil.activities.canvas.ontapped

import com.therealbluepandabear.pixapencil.R
import com.therealbluepandabear.pixapencil.activities.canvas.CanvasActivity
import com.therealbluepandabear.pixapencil.database.AppData
import com.therealbluepandabear.pixapencil.enums.SnackbarDuration
import com.therealbluepandabear.pixapencil.extensions.showDialog
import com.therealbluepandabear.pixapencil.extensions.showSnackbar
import com.therealbluepandabear.pixapencil.models.ColorPalette
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

fun CanvasActivity.extendedOnColorPaletteLongTapped(selectedColorPalette: ColorPalette) {
    val name = selectedColorPalette.colorPaletteName

    if (!selectedColorPalette.isPrimaryColorPalette) {
        showDialog(
            getString(R.string.dialog_delete_pixel_art_project_title, name),
            getString(R.string.dialog_delete_pixel_art_project_text, name),
            getString(R.string.generic_ok),  { _, _ ->
                CoroutineScope(Dispatchers.IO).launch {
                    AppData.colorPalettesDB.colorPalettesDao().deleteColorPalette(selectedColorPalette)
                } }, getString(R.string.generic_cancel), null
        )
    } else {
        binding.activityCanvasCoordinatorLayout.showSnackbar(getString(R.string.snackbar_cannot_delete_primary_color_palette_text), SnackbarDuration.Default)
    }
}