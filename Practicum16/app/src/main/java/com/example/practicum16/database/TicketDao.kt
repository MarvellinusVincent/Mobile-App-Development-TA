package com.example.practicum16.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.practicum16.Ticket
import kotlinx.coroutines.flow.Flow
import java.util.UUID

@Dao
interface TicketDao {

    @Query("SELECT * FROM ticket")
    fun getTickets(): Flow<List<Ticket>>

    @Query("SELECT * FROM ticket WHERE id = :id")
    fun getTicket(id: UUID) : Flow<Ticket>

    @Update
    fun updateTicket(ticket: Ticket)

    @Insert
    fun addTicket(ticket: Ticket)

    // challenge 2
    @Delete
    fun deleteTicket(ticket: Ticket)
}
