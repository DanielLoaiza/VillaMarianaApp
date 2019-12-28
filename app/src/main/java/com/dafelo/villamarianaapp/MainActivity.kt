package com.dafelo.villamarianaapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dafelo.villamarianaapp.components.ReservationComponent
import com.dafelo.villamarianaapp.reservation.ReservationFragment
import com.dafelo.villamarianaapp.reservation.entities.Room
import com.dafelo.villamarianaapp.rooms.RoomFragment
import com.dafelo.villamarianaapp.rooms.entities.RoomReservationInfo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RoomFragment.RoomFragmentInteractionListener {

    // Reference to the Login graph
    lateinit var reservationComponent: ReservationComponent

    override fun onListFragmentInteraction(item: RoomReservationInfo) {
       //TODO: implement reservation fragment
    }

    override fun onReserveClicked(item: RoomReservationInfo) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(right_frame.id, ReservationFragment.newInstance())
        transaction.commit()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        reservationComponent =
            (application as Application).applicationComponent.reservationComponent().create()
        // Creation of the login graph using the application graph

        // Make Dagger instantiate @Inject fields in LoginActivity
        reservationComponent.inject(this)

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(left_frame.id, RoomFragment.newInstance())
        transaction.commit()
    }


}
