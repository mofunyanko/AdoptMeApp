package com.example.adoptmeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.viewpager2.widget.ViewPager2
import com.example.adoptmeapp.databinding.ActivityMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView
import kotlinx.android.synthetic.main.activity_top_page.*

class TopPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val onBottomNavigationItemSelectedListener = NavigationBarView.OnItemSelectedListener{ item ->
        when (item.itemId) {
            R.id.eventAnnounce -> {
                viewPager2.currentItem = 0
                return@OnItemSelectedListener true
            }
            R.id.dogCatAdopt -> {
                viewPager2.currentItem = 1
                return@OnItemSelectedListener true
            }
            R.id.vaccination -> {
                viewPager2.currentItem = 2
                return@OnItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_top_page)

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        toolbar.setTitle(R.string.tbTopPage)
        setSupportActionBar(toolbar)

        val actionBarDrawerToggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.app_name, R.string.app_name)
        drawerLayout.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.syncState()

        val bottomNavigationView: BottomNavigationView = findViewById(R.id.bottomNavigation)
        val viewPager2: ViewPager2 = findViewById(R.id.viewPager2)
        viewPager2.adapter = TopPageViewPagerAdapter(supportFragmentManager, lifecycle)
        bottomNavigationView.setOnItemSelectedListener(onBottomNavigationItemSelectedListener)
        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                when (position) {
                    0 -> bottomNavigationView.menu.findItem(R.id.eventAnnounce).isChecked = true
                    1 -> bottomNavigationView.menu.findItem(R.id.dogCatAdopt).isChecked = true
                    2 -> bottomNavigationView.menu.findItem(R.id.vaccination).isChecked = true
                }
            }
        })

        toolbar.setNavigationOnClickListener {
            drawerLayout.open()
        }

        navigationView.setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.infoCreateUpdate -> startActivity(Intent(this@TopPageActivity, InfomationCreateUpdateActivity::class.java))
                R.id.logout -> startActivity(Intent(this@TopPageActivity, MainActivity::class.java))
            }
            it.isChecked = true
            drawerLayout.close()
            true
        }
    }
}