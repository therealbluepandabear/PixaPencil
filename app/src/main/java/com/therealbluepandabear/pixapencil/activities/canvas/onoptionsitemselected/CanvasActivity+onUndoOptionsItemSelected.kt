package com.therealbluepandabear.pixapencil.activities.canvas.onoptionsitemselected

import com.therealbluepandabear.pixapencil.activities.canvas.CanvasActivity
import com.therealbluepandabear.pixapencil.activities.canvas.canvascommands.undo
import com.therealbluepandabear.pixapencil.activities.canvas.onpixeltapped.cindx
import com.therealbluepandabear.pixapencil.activities.canvas.onpixeltapped.polygonCoordinates

fun CanvasActivity.onUndoOptionsItemSelected() {
    canvasCommandsHelperInstance.undo()

    viewModel.currentBitmapAction = null
    polygonCoordinates.clear()
    cindx = 0
}