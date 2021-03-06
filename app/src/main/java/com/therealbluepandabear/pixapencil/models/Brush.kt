package com.therealbluepandabear.pixapencil.models

import com.therealbluepandabear.pixapencil.enums.BrushInstruction

data class Brush(val brushInstructionData: List<BrushInstructionCommand>, val brushImage: Int) {
    var id: Int = 0

    fun convertBrushInstructionDataToXYPositionData(from: Coordinates): List<Coordinates> {
        val instructions = mutableListOf<Coordinates>()

        for (brushInstruction in brushInstructionData) {
            when (brushInstruction.brushInstruction) {
                BrushInstruction.ExpandTop -> {
                    instructions.add(Coordinates(from.x, from.y + brushInstruction.by))
                }

                BrushInstruction.ExpandBottom -> {
                    instructions.add(Coordinates(from.x, from.y - brushInstruction.by))
                }

                BrushInstruction.ExpandLeft -> {
                    instructions.add(Coordinates(from.x - brushInstruction.by, from.y))
                }

                BrushInstruction.ExpandRight -> {
                    instructions.add(Coordinates(from.x + brushInstruction.by, from.y))
                }

                BrushInstruction.ExpandTopRight -> {
                    instructions.add(Coordinates(from.x + brushInstruction.by, from.y + brushInstruction.by))
                }

                BrushInstruction.ExpandTopLeft -> {
                    instructions.add(Coordinates(from.x - brushInstruction.by, from.y + brushInstruction.by))
                }

                BrushInstruction.ExpandBottomRight -> {
                    instructions.add(Coordinates(from.x - brushInstruction.by, from.y - brushInstruction.by))
                }

                BrushInstruction.ExpandBottomLeft -> {
                    instructions.add(Coordinates(from.x + brushInstruction.by, from.y - brushInstruction.by))
                }
            }
        }

        return instructions
    }
}