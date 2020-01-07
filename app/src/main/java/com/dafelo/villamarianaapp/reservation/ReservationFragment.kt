package com.dafelo.villamarianaapp.reservation

import android.app.DatePickerDialog
import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.dafelo.villamarianaapp.MainActivity

import com.dafelo.villamarianaapp.R
import com.dafelo.villamarianaapp.databinding.ReservationFragmentBinding
import java.util.*
import javax.inject.Inject


class ReservationFragment : Fragment() {

    companion object {
        fun newInstance() = ReservationFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: ReservationViewModel

    private lateinit var binding: ReservationFragmentBinding

    private val c = Calendar.getInstance()
    private val year = c.get(Calendar.YEAR)
    private val month = c.get(Calendar.MONTH)
    private val day = c.get(Calendar.DAY_OF_MONTH)
    private val ZERO = "0"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.reservation_fragment, container, false)

        val listener = getDateClickListener()
        binding.textViewStartDate.setOnClickListener(listener)
        binding.textViewEndDate.setOnClickListener(listener)
        binding.viewmodel = viewModel
        return binding.root
    }

    private fun getDateClickListener(): View.OnClickListener {

        return View.OnClickListener {
            val datePicker = DatePickerDialog(
                requireContext(),
                DatePickerDialog.OnDateSetListener { view, year, month, dayOfMonth ->
                    val currentMonth = month + 1

                    val formattedDay =
                        if (dayOfMonth < 10) ZERO + dayOfMonth.toString() else dayOfMonth.toString()

                    val formattedMonth =
                        if (currentMonth < 10) ZERO + currentMonth.toString() else currentMonth.toString()

                    it as TextView
                    it.text = "$formattedDay/$formattedMonth/$year"
                }, year, month, day
            )

            datePicker.datePicker.minDate = System.currentTimeMillis() - 1000
            datePicker.show()

        }
    }

    override fun onAttach(context: Context) {
        (activity as MainActivity).reservationComponent.reservationComponent().create().inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[ReservationViewModel::class.java]
        super.onAttach(context)
    }
}
