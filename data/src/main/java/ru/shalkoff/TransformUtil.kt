package ru.shalkoff

interface Transformable<T> {

    fun transform(): T
}

fun <T1 : Transformable<T2>, T2> List<T1>.transformList(): List<T2> {
    return this.map { it.transform() }
}