package com.example.practicum14

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.practicum14.databinding.ListItemTicketBinding
import android.text.format.DateFormat
import java.util.UUID

class TicketHolder(private val binding: ListItemTicketBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(ticket: Ticket, onTicketClicked: (ticketId: UUID) -> Unit) {
        val formattedDate = DateFormat.format("EEEE, MMMM dd, yyyy", ticket.date).toString()
        binding.ticketTitle.text = ticket.title
        binding.ticketDate.text = formattedDate
        binding.root.setOnClickListener {
            onTicketClicked(ticket.id)
        }
        binding.ticketSolved.visibility = if (ticket.isSolved) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}

class TicketListAdapter(private val tickets: List<Ticket>, private val onTicketClicked: (ticketId: UUID) -> Unit) : RecyclerView.Adapter<TicketHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = ListItemTicketBinding.inflate(inflator, parent, false)
        return TicketHolder(binding)
    }

    override fun getItemCount(): Int = tickets.size

    override fun onBindViewHolder(holder: TicketHolder, position: Int) {
        val ticket = tickets[position]
        holder.bind(ticket, onTicketClicked)
    }
}
