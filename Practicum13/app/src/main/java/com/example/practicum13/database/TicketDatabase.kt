package com.example.practicum13.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.practicum13.database.TicketTypeConverter
import com.example.practicum13.Ticket

@Database(entities = [ Ticket::class ], version = 1)
@TypeConverters(TicketTypeConverter::class)
abstract class TicketDatabase : RoomDatabase() {
    abstract fun ticketDao(): TicketDao
}