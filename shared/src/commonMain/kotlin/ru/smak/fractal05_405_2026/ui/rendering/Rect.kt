package ru.smak.fractal05_405_2026.ui.rendering

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import kotlin.math.absoluteValue
import kotlin.math.min

class Rect {
    private var point1: Offset? = null
    private var point2: Offset? = null

    val topLeft: Offset?
        get() = point1?.let{ p1 ->
            point2?.let{ p2 ->
                Offset(
                    min(p1.x, p2.x),
                    min(p1.y, p2.y)
                )
            }
        }

    val size: Size?
        get() = point1?.let{ p1 ->
            point2?.let{ p2 ->
                Size(
                    (p1.x - p2.x).absoluteValue,
                    (p1.y - p2.y).absoluteValue
                )
            }
        }

    val isDefined: Boolean
        get() = point1 != null && point2 != null

    fun addPoint(point: Offset) {
        if (point1 == null) point1 = point
        else point2 = point
    }
}