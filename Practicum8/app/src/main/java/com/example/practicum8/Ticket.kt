package com.example.practicum8

import java.util.Date
import java.util.UUID

data class Ticket (
    val id: UUID,
    val title: String,
    val date: Date,
    val isSolved: Boolean,
    val requiresManager: Boolean
)