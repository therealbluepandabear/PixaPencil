package com.therealbluepandabear.pixapencil.activities.canvas.onactioncompleted

import com.therealbluepandabear.pixapencil.R
import com.therealbluepandabear.pixapencil.activities.canvas.CanvasActivity
import com.therealbluepandabear.pixapencil.extensions.disable
import com.therealbluepandabear.pixapencil.models.BitmapAction

fun CanvasActivity.onRedoActionCompleted(undoStack: List<BitmapAction>) {
    if (undoStack.isEmpty()) {
        menu.findItem(R.id.activityCanvasTopAppMenu_redo_item).disable()
    }
}