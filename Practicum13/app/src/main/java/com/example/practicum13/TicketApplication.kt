package com.example.practicum13

import android.app.Application

class TicketApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        TicketRepository.initialize(this)
    }
}