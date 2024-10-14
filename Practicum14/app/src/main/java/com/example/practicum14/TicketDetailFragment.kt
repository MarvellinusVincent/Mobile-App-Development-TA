package com.example.practicum14

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.setFragmentResultListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.practicum14.databinding.FragmentTicketDetailBinding
import kotlinx.coroutines.launch
import java.util.Date
import java.util.UUID

class TicketDetailFragment : Fragment() {
    private val args: TicketDetailFragmentArgs by navArgs()
    private val ticketDetailViewModel: TicketDetailViewModel by viewModels {
        TicketDetailViewModelFactory(args.ticketId)
    }
    private var _binding: FragmentTicketDetailBinding? = null
    private val binding
        get() = checkNotNull(_binding) {
            "Cannot access the view because it is null."
        }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTicketDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            ticketTitle.doOnTextChanged { text, _, _, _ ->
                ticketDetailViewModel.updateTicket { oldTicket ->
                    oldTicket.copy(title = text.toString())
                }
            }

            ticketSolved.setOnCheckedChangeListener { _, isChecked ->
                ticketDetailViewModel.updateTicket { oldTicket ->
                    oldTicket.copy(isSolved = isChecked)
                }
            }

            // challenge 3

            ticketTime.setOnClickListener {
                TimePickerFragment().show(parentFragmentManager, "TimePicker")
            }
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                ticketDetailViewModel.ticket.collect { ticket ->
                    ticket?.let { updateUi(it) }
                }
            }
        }

        // challenge 3
        setFragmentResultListener(TimePickerFragment.REQUEST_KEY_TIME) { _, bundle ->
            val newTime = bundle.getSerializable(TimePickerFragment.BUNDLE_KEY_TIME) as Date
            binding.ticketTime.text = newTime.toString()
        }

        setFragmentResultListener(DatePickerFragment.REQUEST_KEY_DATE) { _, bundle ->
            val newDate = bundle.getSerializable(DatePickerFragment.BUNDLE_KEY_DATE) as Date
            ticketDetailViewModel.updateTicket { it.copy(date = newDate) }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun updateUi(ticket: Ticket) {
        binding.apply {
            if (ticketTitle.text.toString() != ticket.title) {
                ticketTitle.setText(ticket.title)
            }
            ticketDate.text = ticket.date.toString()
            // challenge 3
            ticketTime.text = "Select Time"
            ticketSolved.isChecked = ticket.isSolved
        }
    }
}
