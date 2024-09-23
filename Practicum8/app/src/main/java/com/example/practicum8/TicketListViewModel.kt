package com.example.practicum8

import androidx.lifecycle.ViewModel
import java.util.Date
import java.util.UUID

class TicketListViewModel : ViewModel() {
    val tickets = mutableListOf<Ticket>()

    init {
        for (i in 0 until 100) {
            tickets += Ticket(
                UUID.randomUUID(),
                "Ticket #$i",
                Date(),
                i % 2 == 0,  // Some tickets are solved
                i % 5 == 0   // Every fifth ticket requires manager intervention
            )
        }
    }
}