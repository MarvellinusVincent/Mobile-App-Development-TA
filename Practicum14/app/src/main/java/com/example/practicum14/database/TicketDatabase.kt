package com.example.practicum14.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.practicum14.database.TicketTypeConverter
import com.example.practicum14.Ticket

@Database(entities = [ Ticket::class ], version = 1)
@TypeConverters(TicketTypeConverter::class)
abstract class TicketDatabase : RoomDatabase() {
    abstract fun ticketDao(): TicketDao
}