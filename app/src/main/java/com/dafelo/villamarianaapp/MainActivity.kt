package com.dafelo.villamarianaapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.dafelo.villamarianaapp.components.ReservationComponent
import com.dafelo.villamarianaapp.reservation.entities.Room
import com.dafelo.villamarianaapp.rooms.RoomFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), RoomFragment.OnListFragmentInteractionListener {

    // Reference to the Login graph
    lateinit var reservationComponent: ReservationComponent

    override fun onListFragmentInteraction(item: Room?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
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
