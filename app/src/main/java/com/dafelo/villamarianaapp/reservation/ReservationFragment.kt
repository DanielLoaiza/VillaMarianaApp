package com.dafelo.villamarianaapp.reservation

import android.content.Context
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.dafelo.villamarianaapp.MainActivity

import com.dafelo.villamarianaapp.R
import com.dafelo.villamarianaapp.rooms.RoomsViewModel
import javax.inject.Inject

class ReservationFragment : Fragment() {

    companion object {
        fun newInstance() = ReservationFragment()
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: ReservationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.reservation_fragment, container, false)
    }

    override fun onAttach(context: Context) {
        (activity as MainActivity).reservationComponent.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory)[ReservationViewModel::class.java]
        super.onAttach(context)
    }
}
