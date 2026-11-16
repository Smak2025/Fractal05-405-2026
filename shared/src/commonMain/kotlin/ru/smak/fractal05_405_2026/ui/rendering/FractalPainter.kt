package ru.smak.fractal05_405_2026.ui.rendering

import androidx.compose.ui.graphics.drawscope.DrawScope
import ru.smak.fractal05_405_2026.domain.Plane

interface FractalPainter {
    fun paint(plane: Plane)
}