package com.therealbluepandabear.pixapencil.activities.canvas

import android.view.animation.DecelerateInterpolator
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import com.takusemba.spotlight.OnTargetListener
import com.takusemba.spotlight.Spotlight
import com.takusemba.spotlight.Target
import com.takusemba.spotlight.shape.Circle
import com.takusemba.spotlight.shape.RoundedRectangle
import com.therealbluepandabear.pixapencil.R

fun CanvasActivity.startSpotLight() {
    val firstRoot = FrameLayout(this)
    val lyt = layoutInflater.inflate(R.layout.layout_target, firstRoot)
    val text = lyt.findViewById<TextView>(R.id.layoutTarget_text)
    val targets = ArrayList<Target>()

    val firstTarget = Target.Builder()
        .setAnchor(binding.activityCanvasColorSwitcherView)
        .setOnTargetListener(object : OnTargetListener {
            override fun onEnded() {}

            override fun onStarted() {
                text.text = getString(R.string.spot_light_activity_canvas_1)
            }

        })
        .setShape(Circle(300f))
        .setOverlay(lyt)
        .build()

    targets.add(firstTarget)

    val secondTarget = Target.Builder()
        .setAnchor(binding.activityCanvasViewPager2)
        .setOnTargetListener(object : OnTargetListener {
            override fun onEnded() {}

            override fun onStarted() {
                lyt.y -= 400
                text.text = getString(R.string.spot_light_activity_canvas_2)
            }

        })
        .setShape(RoundedRectangle(binding.activityCanvasViewPager2.measuredHeight.toFloat(), binding.activityCanvasViewPager2.measuredWidth.toFloat(), 20f))
        .setOverlay(lyt)
        .build()

    targets.add(secondTarget)

    val thirdTarget = Target.Builder()
        .setAnchor(binding.activityCanvasViewPager2)
        .setOnTargetListener(object : OnTargetListener {
            override fun onEnded() {}

            override fun onStarted() {
                lyt.y -= 200
                text.text = getString(R.string.spot_light_activity_canvas_3)
            }

        })
        .setShape(RoundedRectangle(binding.activityCanvasViewPager2.measuredHeight.toFloat() + 300, binding.activityCanvasViewPager2.measuredWidth.toFloat(), 20f))
        .setOverlay(lyt)
        .build()

    targets.add(thirdTarget)

    val fourthTarget = Target.Builder()
        .setAnchor(binding.activityCanvasViewPager2)
        .setOnTargetListener(object : OnTargetListener {
            override fun onEnded() {}

            override fun onStarted() {
                lyt.y += 200
                text.text = getString(R.string.spot_light_activity_canvas_4)
            }

        })
        .setShape(RoundedRectangle(binding.activityCanvasViewPager2.measuredHeight.toFloat(), binding.activityCanvasViewPager2.measuredWidth.toFloat(), 20f))
        .setOverlay(lyt)
        .build()

    targets.add(fourthTarget)

    val fifthTarget = Target.Builder()
        .setAnchor(binding.activityCanvasViewPager2)
        .setOnTargetListener(object : OnTargetListener {
            override fun onEnded() {}

            override fun onStarted() {
                lyt.y -= 200
                text.text = getString(R.string.spot_light_activity_canvas_5)
            }

        })
        .setShape(RoundedRectangle(binding.activityCanvasViewPager2.measuredHeight.toFloat() + 300, binding.activityCanvasViewPager2.measuredWidth.toFloat(), 20f))
        .setOverlay(lyt)
        .build()

    targets.add(fifthTarget)

    val sixthTarget = Target.Builder()
        .setAnchor(binding.activityCanvasViewPager2)
        .setOnTargetListener(object : OnTargetListener {
            override fun onEnded() {}

            override fun onStarted() {
                lyt.y += 200
                text.text = getString(R.string.spot_light_activity_canvas_6)
            }

        })
        .setShape(RoundedRectangle(binding.activityCanvasViewPager2.measuredHeight.toFloat(), binding.activityCanvasViewPager2.measuredWidth.toFloat(), 20f))
        .setOverlay(lyt)
        .build()

    targets.add(sixthTarget)

    val seventhTarget = Target.Builder()
        .setAnchor(binding.activityCanvasViewPager2)
        .setOnTargetListener(object : OnTargetListener {
            override fun onEnded() {}

            override fun onStarted() {
                lyt.y -= 200
                text.text = getString(R.string.spot_light_activity_canvas_7)
            }

        })
        .setShape(RoundedRectangle(binding.activityCanvasViewPager2.measuredHeight.toFloat() + 300, binding.activityCanvasViewPager2.measuredWidth.toFloat(), 20f))
        .setOverlay(lyt)
        .build()

    targets.add(seventhTarget)

    val eighthTarget = Target.Builder()
        .setAnchor(binding.activityCanvasViewPager2)
        .setOnTargetListener(object : OnTargetListener {
            override fun onEnded() {}

            override fun onStarted() {
                lyt.y += 200
                text.text = getString(R.string.spot_light_activity_canvas_8)
            }

        })
        .setShape(RoundedRectangle(binding.activityCanvasViewPager2.measuredHeight.toFloat(), binding.activityCanvasViewPager2.measuredWidth.toFloat(), 20f))
        .setOverlay(lyt)
        .build()

    targets.add(eighthTarget)

    val spotlight = Spotlight.Builder(this)
        .setTargets(targets)
        .setBackgroundColorRes(R.color.spotlightBackground)
        .setDuration(1000L)
        .setAnimation(DecelerateInterpolator(2f))
        .build()

    lyt.findViewById<Button>(R.id.layoutTarget_nextButton).setOnClickListener {
        spotlight.next()
    }

    lyt.findViewById<Button>(R.id.layoutTarget_closeButton).setOnClickListener {
        spotlight.finish()
    }

    spotlight.start()
}