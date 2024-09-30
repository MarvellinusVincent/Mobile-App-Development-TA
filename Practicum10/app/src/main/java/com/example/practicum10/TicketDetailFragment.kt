package com.example.practicum10

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import com.example.practicum10.databinding.FragmentTicketDetailBinding
import java.util.Date
import java.util.UUID

class TicketDetailFragment : Fragment() {
    lateinit var ticket: Ticket
    private var _binding: FragmentTicketDetailBinding? = null
    private val binding get() = checkNotNull(_binding) { "Cannot access the view because it is null" }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ticket = Ticket(UUID.randomUUID(), "", Date(), false)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTicketDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            ticketTitle.doOnTextChanged { text, _, _, _ ->
                ticket = ticket.copy(title = text.toString())
            }
            ticketDate.text = ticket.date.toString()
            ticketDate.isEnabled = false
            ticketSolved.setOnCheckedChangeListener { _, isChecked ->
                ticket = ticket.copy(isSolved = isChecked)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
