package com.realtomjoney.pyxlmoose.activities.canvas

import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.view.DragEvent
import android.view.View
import com.google.android.material.tabs.TabLayout
import com.realtomjoney.pyxlmoose.*
import com.realtomjoney.pyxlmoose.extensions.navigateTo
import com.realtomjoney.pyxlmoose.fragments.brushes.BrushesFragment
import com.realtomjoney.pyxlmoose.fragments.colorpalettes.ColorPalettesFragment
import com.realtomjoney.pyxlmoose.fragments.filters.FiltersFragment
import com.realtomjoney.pyxlmoose.fragments.tools.ToolsFragment
import com.realtomjoney.pyxlmoose.utility.StringConstants
import android.view.MotionEvent

import android.view.View.OnHoverListener


fun CanvasActivity.openColorPickerDialog(colorPaletteMode: Boolean = false) {
    colorPickerFragmentInstance = initColorPickerFragmentInstance(colorPaletteMode)
    currentFragmentInstance = colorPickerFragmentInstance
    navigateTo(supportFragmentManager, colorPickerFragmentInstance, R.id.activityCanvas_primaryFragmentHost, StringConstants.FRAGMENT_COLOR_PICKER_TITLE, binding.activityCanvasPrimaryFragmentHost, binding.activityCanvasRootLayout)
}

fun clearCanvas() {
    canvasInstance.myCanvasViewInstance.clearCanvas()
}

fun CanvasActivity.setOnClickListeners() {
    brushesFragmentInstance = BrushesFragment.newInstance()
    supportFragmentManager.beginTransaction().add(R.id.activityCanvas_tabLayoutFragmentHost, brushesFragmentInstance!!).commit()

    colorPalettesFragmentInstance = ColorPalettesFragment.newInstance(this)
    supportFragmentManager.beginTransaction().add(R.id.activityCanvas_tabLayoutFragmentHost, colorPalettesFragmentInstance!!).commit()

    filtersFragmentInstance = FiltersFragment.newInstance()
    supportFragmentManager.beginTransaction().add(R.id.activityCanvas_tabLayoutFragmentHost, filtersFragmentInstance!!).commit()

    toolsFragmentInstance = ToolsFragment.newInstance()
    supportFragmentManager.beginTransaction().add(R.id.activityCanvas_tabLayoutFragmentHost, toolsFragmentInstance!!).commit()

    binding.activityCanvasTabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
        override fun onTabSelected(tab: TabLayout.Tab) {
            when (tab.text) {
                getString(R.string.tab_tools_str) -> {
                    colorPalettesFragmentInstance!!.requireView().visibility = View.GONE
                    filtersFragmentInstance!!.requireView().visibility = View.GONE
                    brushesFragmentInstance!!.requireView().visibility = View.GONE
                    toolsFragmentInstance!!.requireView().visibility = View.VISIBLE
                }
                getString(R.string.tab_filters_str) -> {
                    toolsFragmentInstance!!.requireView().visibility = View.GONE
                    colorPalettesFragmentInstance!!.requireView().visibility = View.GONE
                    brushesFragmentInstance!!.requireView().visibility = View.GONE
                    filtersFragmentInstance!!.requireView().visibility = View.VISIBLE
                }
                getString(R.string.tab_color_palettes_str) -> {
                    toolsFragmentInstance!!.requireView().visibility = View.GONE
                    filtersFragmentInstance!!.requireView().visibility = View.GONE
                    brushesFragmentInstance!!.requireView().visibility = View.GONE
                    colorPalettesFragmentInstance!!.requireView().visibility = View.VISIBLE
                }
                getString(R.string.tab_brushes_str) -> {
                    colorPalettesFragmentInstance!!.requireView().visibility = View.GONE
                    filtersFragmentInstance!!.requireView().visibility = View.GONE
                    toolsFragmentInstance!!.requireView().visibility = View.GONE
                    brushesFragmentInstance!!.requireView().visibility = View.VISIBLE
                }
            }
        }

        override fun onTabReselected(tab: TabLayout.Tab) { }

        override fun onTabUnselected(tab: TabLayout.Tab) { }
    })

    binding.activityCanvasColorSecondaryView.setOnClickListener {
        isPrimaryColorSelected = false
        setPixelColor((binding.activityCanvasColorSecondaryView.background as ColorDrawable).color)
    }

    binding.activityCanvasColorPrimaryView.setOnLongClickListener {
        isPrimaryColorSelected = true
        openColorPickerDialog()
        hideMenuItems()
        true
    }


    binding.activityCanvasColorPrimaryView.setOnClickListener {
        isPrimaryColorSelected = true
        setPixelColor((binding.activityCanvasColorPrimaryView.background as ColorDrawable).color)
    }

    binding.activityCanvasColorSecondaryView.setOnLongClickListener {
        isPrimaryColorSelected = false
        openColorPickerDialog()
        hideMenuItems()
        true
    }
}