package com.dafelo.villamarianaapp.rooms


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.dafelo.villamarianaapp.R
import com.dafelo.villamarianaapp.reservation.entities.Room
import com.dafelo.villamarianaapp.rooms.RoomFragment.OnListFragmentInteractionListener
import kotlinx.android.synthetic.main.fragment_room.view.*

class RoomRecyclerViewAdapter(
    private val rooms: MutableList<Room>,
    private val mListener: OnListFragmentInteractionListener?
) : RecyclerView.Adapter<RoomRecyclerViewAdapter.ViewHolder>() {

    private val mOnClickListener: View.OnClickListener

    init {
        mOnClickListener = View.OnClickListener { v ->
            val item = v.tag as Room
            // Notify the active callbacks interface (the activity, if the fragment is attached to
            // one) that an item has been selected.
            mListener?.onListFragmentInteraction(item)
        }
    }

    fun updateRooms(updatedRooms: List<Room>) {
        rooms.clear()
        rooms.addAll(updatedRooms)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_room, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = rooms[position]
        holder.roomIdView.text = item.number.toString()
        holder.roomContentView.text = "Daniel Loaiza"

        with(holder.roomView) {
            tag = item
            setOnClickListener(mOnClickListener)
        }
    }

    override fun getItemCount(): Int = rooms.size

    inner class ViewHolder(val roomView: View) : RecyclerView.ViewHolder(roomView) {
        val roomIdView: TextView = roomView.item_number
        val roomContentView: TextView = roomView.content

        override fun toString(): String {
            return super.toString() + " '" + roomContentView.text + "'"
        }
    }
}
