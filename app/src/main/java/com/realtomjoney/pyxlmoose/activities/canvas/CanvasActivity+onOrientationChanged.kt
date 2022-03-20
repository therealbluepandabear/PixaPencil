package com.realtomjoney.pyxlmoose.activities.canvas

import com.realtomjoney.pyxlmoose.R
import com.realtomjoney.pyxlmoose.fragments.outercanvas.OuterCanvasFragment

fun CanvasActivity.onOrientationChanged() {
    for (fragment in supportFragmentManager.fragments) {
        if (fragment is OuterCanvasFragment) {
            supportFragmentManager.beginTransaction()
                .remove(fragment).commit()
        }
    }

    outerCanvasInstance = OuterCanvasFragment.newInstance(width, height)
    supportFragmentManager.beginTransaction()
        .add(R.id.activityCanvas_outerCanvasFragmentHost, outerCanvasInstance).commit()
}