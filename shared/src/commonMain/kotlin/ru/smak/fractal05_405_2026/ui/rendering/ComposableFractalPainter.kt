package ru.smak.fractal05_405_2026.ui.rendering

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.DrawScope
import ru.smak.fractal05_405_2026.application.Converter
import ru.smak.fractal05_405_2026.domain.AlgebraicFractal
import ru.smak.fractal05_405_2026.domain.Complex
import ru.smak.fractal05_405_2026.domain.Plane
import kotlin.math.cos
import kotlin.math.sin

class ComposableFractalPainter(
    private val fractal: AlgebraicFractal,
) : FractalPainter{

    var drawScope: DrawScope? = null

    override fun paint(plane: Plane) {
        drawScope?.let { scope ->
            val width = scope.size.width
            val height = scope.size.height
            for (y in 0..<height.toInt()) {
                for (x in 0..<width.toInt()) {
                    val xC = Converter.xScrToCrt(x.toFloat(), plane)
                    val yC = Converter.yScrToCrt(y.toFloat(), plane)
                    fractal.isInSet(Complex(xC, yC)).let{
                        val preColor = 1f - it
                        if (preColor == 0f) Color.Black
                        else {
                            val r = cos(13f * preColor)
                            val g = sin(7f * preColor) * cos(8 * (1f - preColor))
                            val b = cos(21f * preColor) * cos(21f * preColor)
                            Color(r, g, b)
                        }
                    }.also { color ->
                        scope.drawRect(
                            color,
                            Offset(x.toFloat(), y.toFloat()),
                            Size(1f, 1f)
                        )
                    }
                }
            }
        }
    }

}