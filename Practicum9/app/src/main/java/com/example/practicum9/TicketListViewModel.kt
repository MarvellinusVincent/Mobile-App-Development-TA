package com.example.practicum9

import androidx.lifecycle.ViewModel
import java.util.Date
import java.util.UUID

class TicketListViewModel : ViewModel() {
    val tickets = mutableListOf<Ticket>()

    init {
        for (i in 0 until 100) {
            tickets += Ticket(UUID.randomUUID(), "ticket #$i", Date(), i % 2 == 0)
        }
    }
}