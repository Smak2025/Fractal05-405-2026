package ru.smak.fractal05_405_2026.ui.rendering

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import kotlin.math.absoluteValue
import kotlin.math.max
import kotlin.math.min

class Rect private constructor(
    private val point1: Offset?,
    private val point2: Offset? = null,
){
    constructor() : this(null)

    val topLeft: Offset?
        get() = point1?.let{ p1 ->
            point2?.let{ p2 ->
                Offset(
                    min(p1.x, p2.x),
                    min(p1.y, p2.y)
                )
            }
        }

    val bottomRight: Offset?
        get() = point1?.let { p1 ->
            point2?.let{ p2 ->
                Offset(
                    max(p1.x, p2.x),
                    max(p1.y, p2.y)
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

    fun addPoint(point: Offset) : Rect {
        if (point1 == null) return Rect(point, null)
        else return Rect(point1, point)
    }

    fun clear(): Rect{
        return Rect(null)
    }
}