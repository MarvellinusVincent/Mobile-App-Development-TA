package com.example.practicum14

import android.app.Application

class TicketApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        TicketRepository.initialize(this)
    }
}