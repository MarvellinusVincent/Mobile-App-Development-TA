package com.example.practicum11

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.reduce
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.flow.transform
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull

fun main() {
    runBlocking {
        val sum = milkMeasurement().reduce { x, y -> x + y}
        println("Sum = $sum")
    }
}

suspend fun format(measurement: Float): String {
    return "$measurement lb"
}

fun milkMeasurement(): Flow<Float> =
    flow {
        for (i in arrayOf(180F, 76F, 10F, 92F)) {
            delay(100)
            emit(i)
        }
    }