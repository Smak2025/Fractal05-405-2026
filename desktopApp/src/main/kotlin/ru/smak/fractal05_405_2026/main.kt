package ru.smak.fractal05_405_2026

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ru.smak.fractal05_405_2026.domain.AlgebraicFractal
import ru.smak.fractal05_405_2026.domain.Mandelbrot
import ru.smak.fractal05_405_2026.ui.App
import ru.smak.fractal05_405_2026.ui.rendering.ComposableFractalPainter
import ru.smak.fractal05_405_2026.ui.viewmodels.MainViewModel

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Fractal05-405-2026",
    ) {
        val nMax = 100
        val rSquared = 4.0
        val fractal: AlgebraicFractal = remember { Mandelbrot(nMax, rSquared) }
        val painter = remember { ComposableFractalPainter(fractal) }
        val viewModel = remember { MainViewModel() }
        App(viewModel, painter)
    }
}