package com.example.practicum8

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.practicum8.databinding.ListItemTicketBinding
import com.example.practicum8.databinding.ListItemTicketManagerBinding

class NormalTicketHolder(
    private val binding: ListItemTicketBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(ticket: Ticket) {
        binding.ticketTitle.text = ticket.title
        binding.ticketDate.text = ticket.date.toString()

        binding.root.setOnClickListener {
            Toast.makeText(binding.root.context, "${ticket.title} clicked!", Toast.LENGTH_SHORT).show()
        }
    }
}

class ManagerTicketHolder(
    private val binding: ListItemTicketManagerBinding
) : RecyclerView.ViewHolder(binding.root) {
    fun bind(ticket: Ticket) {
        binding.ticketTitle.text = ticket.title
        binding.ticketDate.text = ticket.date.toString()

        binding.contactManagerButton.setOnClickListener {
            Toast.makeText(binding.root.context, "Contacting manager for ${ticket.title}", Toast.LENGTH_SHORT).show()
        }
    }
}

class TicketListAdapter(
    private val tickets: List<Ticket>
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_NORMAL = 0
        private const val VIEW_TYPE_MANAGER = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (tickets[position].requiresManager) VIEW_TYPE_MANAGER else VIEW_TYPE_NORMAL
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_MANAGER) {
            val inflator = LayoutInflater.from(parent.context)
            val binding = ListItemTicketManagerBinding.inflate(inflator, parent, false)
            ManagerTicketHolder(binding)
        } else {
            val inflator = LayoutInflater.from(parent.context)
            val binding = ListItemTicketBinding.inflate(inflator, parent, false)
            NormalTicketHolder(binding)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val ticket = tickets[position]
        if (holder is ManagerTicketHolder) {
            holder.bind(ticket)
        } else if (holder is NormalTicketHolder) {
            holder.bind(ticket)
        }
    }

    override fun getItemCount(): Int {
        return tickets.size
    }
}
