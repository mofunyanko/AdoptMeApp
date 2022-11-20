package com.example.adoptmeapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class EventListRecyclerViewAdapter(private val eventList: ArrayList<Event>):
    RecyclerView.Adapter<EventListRecyclerViewAdapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ImageView
        val title: TextView
        val location: TextView
        val btDetails: Button

        init {
            image = view.findViewById(R.id.image)
            title = view.findViewById(R.id.title)
            location = view.findViewById(R.id.location)
            btDetails = view.findViewById(R.id.btDetails)
        }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(viewGroup.context).inflate(R.layout.list_event_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        val event = eventList[position]

        viewHolder.image.setImageResource(event.imageId)
        viewHolder.title.text = event.title
        viewHolder.location.text = event.location

        viewHolder.btDetails.setOnClickListener {

        }
    }

    override fun getItemCount(): Int = eventList.size
}