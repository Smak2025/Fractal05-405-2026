package ru.smak.fractal05_405_2026.ui.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.unit.IntSize
import androidx.lifecycle.ViewModel
import ru.smak.fractal05_405_2026.domain.AlgebraicFractal
import ru.smak.fractal05_405_2026.domain.Plane
import ru.smak.fractal05_405_2026.ui.rendering.Rect
import kotlin.collections.copy

class MainViewModel: ViewModel() {
    var plane: Plane by mutableStateOf(Plane(
        -2.0,
        1.0,
        -1.0,
        1.0
    ))

    var showSelection by mutableStateOf(false)

    val selectionRect by mutableStateOf(Rect())

    fun onCanvasSizeChange(size: IntSize) {
        if (size.width <= 0 || size.height <= 0) return
        plane = plane.copy(width = size.width, height = size.height)
    }

    fun addSelectionPoint(point: Offset) {
        selectionRect.addPoint(point)
    }
}