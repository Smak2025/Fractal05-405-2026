package ru.smak.fractal05_405_2026.domain

class Mandelbrot(
    val nMax: Int,
    val rSquared: Double = 4.0,
) : AlgebraicFractal {

    override fun isInSet(c: Complex): Boolean {
        val z = Complex()
        for (i in 1..nMax) {
            z *= z
            z += c
            if (z.modulusSquared >= rSquared) return false
        }
        return true
    }

}