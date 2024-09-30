package com.example.practicum10

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.practicum10.databinding.ListItemTicketBinding
import android.text.format.DateFormat

class TicketHolder(private val binding: ListItemTicketBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(ticket: Ticket) {
        val formattedDate = DateFormat.format("EEEE, MMMM dd, yyyy", ticket.date).toString()
        binding.ticketTitle.text = ticket.title
        binding.ticketDate.text = formattedDate
        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, "${ticket.title} clicked!", Toast.LENGTH_SHORT).show()
        }
        binding.ticketSolved.visibility = if (ticket.isSolved) {
            View.VISIBLE
        } else {
            View.GONE
        }
    }
}

class TicketListAdapter(private val tickets: List<Ticket>) : RecyclerView.Adapter<TicketHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TicketHolder {
        val inflator = LayoutInflater.from(parent.context)
        val binding = ListItemTicketBinding.inflate(inflator, parent, false)
        return TicketHolder(binding)
    }

    override fun getItemCount(): Int = tickets.size

    override fun onBindViewHolder(holder: TicketHolder, position: Int) {
        holder.bind(tickets[position])
    }
}
