package ru.smak.fractal05_405_2026

import androidx.compose.runtime.remember
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import ru.smak.fractal05_405_2026.viewmodels.MainViewModel

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "Fractal05-405-2026",
    ) {
        val viewModel = remember { MainViewModel() }
        App()
    }
}