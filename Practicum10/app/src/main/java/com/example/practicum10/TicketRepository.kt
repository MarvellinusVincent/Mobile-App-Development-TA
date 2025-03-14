package com.example.practicum10

import android.content.Context
import androidx.room.Room
import com.example.practicum10.database.TicketDatabase
import kotlinx.coroutines.flow.Flow
import java.util.UUID

private const val DATABASE_NAME = "ticket-database"

class TicketRepository private constructor(context: Context) {

    private val database: TicketDatabase = Room.databaseBuilder(
        context.applicationContext, TicketDatabase::class.java, DATABASE_NAME
    ).createFromAsset(DATABASE_NAME).build()

    suspend fun getTickets(): Flow<List<Ticket>> = database.ticketDao().getTickets()
    suspend fun getTicket(id: UUID): Ticket = database.ticketDao().getTicket(id)

    companion object {
        private var INSTANCE : TicketRepository? = null

        fun initialize (context: Context) {
            if (INSTANCE == null) {
                INSTANCE = TicketRepository(context)
            }
        }

        fun get(): TicketRepository {
            return INSTANCE ?:
            throw IllegalStateException(
                "TicketRepository must be initialized"
            )
        }
    }
}