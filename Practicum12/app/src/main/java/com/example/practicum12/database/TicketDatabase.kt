package com.example.practicum12.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.practicum12.Ticket
import com.example.practicum12.database.TicketTypeConverter

@Database(entities = [ Ticket::class ], version = 1)
@TypeConverters(TicketTypeConverter::class)
abstract class TicketDatabase : RoomDatabase() {
    abstract fun ticketDao(): TicketDao
}