package com.pamlanjut.evolvance20.utils.helper

fun String.toCapitalizedWords(): String {
    return this
        .split(' ', '_', '-')
        .joinToString(" ") { word ->
            word.lowercase().replaceFirstChar { it.uppercase() }
        }
}