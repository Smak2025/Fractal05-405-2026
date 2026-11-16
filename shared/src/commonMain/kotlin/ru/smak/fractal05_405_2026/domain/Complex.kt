package ru.smak.fractal05_405_2026.domain

import kotlin.math.sqrt

class Complex(
    var re: Double = 0.0,
    var im: Double = 0.0,
) {
    operator fun plus(other: Complex) =
        Complex(re + other.re, im + other.im)

    operator fun plusAssign(other: Complex) {
        re += other.re
        im += other.im
    }

    operator fun minus(other: Complex) =
        Complex(re - other.re, im - other.im)

    operator fun minusAssign(other: Complex) {
        re -= other.re
        im -= other.im
    }

    operator fun times(other: Complex) = Complex(
        re * other.re - im * other.im,
        re * other.im + im * other.re
    )

    operator fun timesAssign(other: Complex) {
        val newRe = re * other.re - im * other.im
        im = re * other.im + im * other.re
        re = newRe
    }

    operator fun div(other: Complex) = (other.re * other.re + other.im * other.im).let{
        Complex(
            (re * other.re + im * other.im) / it,
            (im * other.re - re * other.im) / it
        )
    }

    operator fun divAssign(other: Complex) {
        (other.re * other.re + other.im * other.im).let{
            val newRe = (re * other.re + im * other.im) / it
            im = (im * other.re - re * other.im) / it
            re = newRe
        }
    }

    val modulus: Double get() = sqrt(re * re + im * im)

    val modulusSquared get() = re * re + im * im

    override fun toString(): String = buildString{
        append(re)
        append('+')
        append(im)
        append('i')
    }
}