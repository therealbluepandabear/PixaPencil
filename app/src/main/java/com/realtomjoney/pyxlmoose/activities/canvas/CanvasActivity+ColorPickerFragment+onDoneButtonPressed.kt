package com.realtomjoney.pyxlmoose.activities.canvas

import com.realtomjoney.pyxlmoose.adapters.ColorPickerAdapter
import com.realtomjoney.pyxlmoose.converters.JsonConverter
import com.realtomjoney.pyxlmoose.database.AppData
import com.realtomjoney.pyxlmoose.extensions.navigateHome

fun CanvasActivity.extendedOnDoneButtonPressed(selectedColor: Int, colorPaletteMode: Boolean) {
    if (!colorPaletteMode) setPixelColor(selectedColor)
    else {
        val newData = JsonConverter.convertJsonStringToListOfInt(fromDB!!.colorPaletteColorData).toMutableList()
        newData.add(selectedColor)

        AppData.colorPalettesDB.colorPalettesDao().updateColorPaletteColorData(JsonConverter.convertListOfIntToJsonString(newData.toList()), fromDB!!.objId)
        AppData.colorPalettesDB.colorPalettesDao().getAllColorPalettes().observe(this, {
            binding.activityCanvasColorPickerRecyclerView.adapter = ColorPickerAdapter(fromDB!!, this)
            binding.activityCanvasColorPickerRecyclerView.scrollToPosition(JsonConverter.convertJsonStringToListOfInt(fromDB!!.colorPaletteColorData).size)
        })
    }

    currentFragmentInstance = null
    navigateHome(supportFragmentManager, colorPickerFragmentInstance, binding.activityCanvasRootLayout, binding.activityCanvasPrimaryFragmentHost, intent.getStringExtra("PROJECT_TITLE")!!)
}