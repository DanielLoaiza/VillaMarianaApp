package com.dafelo.villamarianaapp.rooms

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dafelo.villamarianaapp.MainActivity
import com.dafelo.villamarianaapp.R
import com.dafelo.villamarianaapp.rooms.entities.RoomReservationInfo
import javax.inject.Inject

/**
 * A fragment representing a list of Items.
 * Activities containing this fragment MUST implement the
 * [RoomFragment.RoomFragmentInteractionListener] interface.
 */
class RoomFragment : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var adapter: RoomRecyclerViewAdapter

    private var listener: RoomFragmentInteractionListener? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_room_list, container, false)

        // Set the adapter
        if (view is RecyclerView) {
            with(view) {
                layoutManager = LinearLayoutManager(context)
                adapter = this@RoomFragment.adapter
            }
        }
        return view
    }

    override fun onAttach(context: Context) {
        (activity as MainActivity).reservationComponent.roomComponent().create().inject(this)
        val vm = ViewModelProviders.of(this, viewModelFactory)[RoomsViewModel::class.java]
        super.onAttach(context)
        if (context is RoomFragmentInteractionListener) {
            listener = context
            adapter = RoomRecyclerViewAdapter(mutableListOf(), listener)
        } else {
            throw RuntimeException("$context must implement OnListFragmentInteractionListener")
        }

        vm.roomReservations.observe(this, Observer {
            adapter.updateRooms(it)
        })
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }


    interface RoomFragmentInteractionListener {
        fun onListFragmentInteraction(item: RoomReservationInfo)
        fun onReserveClicked(item: RoomReservationInfo)
    }

    companion object {

        @JvmStatic
        fun newInstance() = RoomFragment()
    }
}
