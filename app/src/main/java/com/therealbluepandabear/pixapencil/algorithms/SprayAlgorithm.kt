package com.therealbluepandabear.pixapencil.algorithms

import com.therealbluepandabear.pixapencil.activities.canvas.canvascommands.overrideSetPixel
import com.therealbluepandabear.pixapencil.models.Coordinates
import kotlin.math.floor
import kotlin.random.Random

class SprayAlgorithm(private val algorithmInfo: AlgorithmInfoParameter, private var radius: Int, private var strength: Int) {
    fun compute(seed: Coordinates) {
        val ct = floor((radius / 2).toDouble()).toInt()

        val p1 = Coordinates(seed.x + ct, seed.y + ct)
        val p2 = Coordinates(seed.x - ct, seed.y - ct)

        for (i in 0 until strength) {
            val rn1 = Random.nextInt(-ct, ct)
            val rn2 = Random.nextInt(-ct, ct)
            val rn3 = Random.nextInt(-ct, ct)
            val rn4 = Random.nextInt(-ct, ct)

            val randX = Random.nextInt(p2.x + rn1, p1.x + rn2)
            val randY = Random.nextInt(p2.y + rn3, p1.y + rn4)

            val randCoordinates = Coordinates(randX, randY)

            algorithmInfo.canvasCommandsHelperInstance.overrideSetPixel(randCoordinates, algorithmInfo.color)
        }
    }
}