package com.example.adoptmeapp

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView


lateinit var eventListRecyclerViewAdapter: EventListRecyclerViewAdapter
lateinit var eventList: ArrayList<Event>

class EventAnnouncementFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_event_announcement, container, false)

        val event1 = Event("初心者飼い主さん歓迎！しつけ講座のご案内", "新潟動物ふれあいセンター", R.drawable.test_event_announce_foreground)
        val event2 = Event("犬猫を引き取りたい人に！譲渡会のご案内", "石川動物愛護センター", R.drawable.test_event_announce_foreground)
        val event3 = Event("【重要】狂犬病ワクチン接種のご案内!", "○○保健所", R.drawable.test_event_announce_foreground)
        val event4 = Event("猫を飼っている方へ！お風呂講座のご案内", "××動物愛護センター", R.drawable.test_event_announce_foreground)
        val event5 = Event("ペットを飼うこととは 講演会のご案内", "△△ホール", R.drawable.test_event_announce_foreground)
        val event6 = Event("初心者飼い主さん歓迎！しつけ講座のご案内", "新潟動物ふれあいセンター", R.drawable.test_event_announce_foreground)
        val event7 = Event("初心者飼い主さん歓迎！しつけ講座のご案内", "新潟動物ふれあいセンター", R.drawable.test_event_announce_foreground)
        val event8 = Event("初心者飼い主さん歓迎！しつけ講座のご案内", "新潟動物ふれあいセンター", R.drawable.test_event_announce_foreground)

        eventList = arrayListOf(event1, event2, event3, event4, event5, event6, event7, event8)

        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view)

        recyclerView.layoutManager = LinearLayoutManager(context)

        eventListRecyclerViewAdapter = EventListRecyclerViewAdapter(eventList)
        recyclerView.adapter = eventListRecyclerViewAdapter

        eventListRecyclerViewAdapter.setOnItemClickListener(object : EventListRecyclerViewAdapter.OnItemClickListener {
            override fun onItemClick(event: Event) {
                val intent = Intent(context, ViewDetailsActivity::class.java)
                startActivity(intent)
            }})
        return view
    }
}