package ru.smak.fractal05_405_2026.ui

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.smak.fractal05_405_2026.domain.AlgebraicFractal
import ru.smak.fractal05_405_2026.ui.rendering.ComposableFractalPainter
import ru.smak.fractal05_405_2026.ui.rendering.FractalPainter
import ru.smak.fractal05_405_2026.ui.viewmodels.MainViewModel

@Composable
fun App(
    viewModel: MainViewModel,
    painter: ComposableFractalPainter,
) {
    MaterialTheme {
        Canvas(modifier = Modifier
            .fillMaxSize()
            .padding(8.dp)
            .background(Color.White)
            .onSizeChanged { viewModel.onCanvasSizeChange(it) }
        ){
            painter.drawScope = this
            with(painter) { paint(viewModel.plane) }
        }
    }
}