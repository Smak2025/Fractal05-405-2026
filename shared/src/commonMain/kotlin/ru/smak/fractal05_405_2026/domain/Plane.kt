package ru.smak.fractal05_405_2026.domain

data class Plane(
    var xMin: Double,
    var xMax: Double,
    var yMin: Double,
    var yMax: Double,
    var width: Int = 0,
    var height: Int = 0
){
    val xDen : Double
        get() = width / (xMax-xMin)
    val yDen : Double
        get() = height / (yMax-yMin)
}