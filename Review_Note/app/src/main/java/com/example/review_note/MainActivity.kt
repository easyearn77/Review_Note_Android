package com.example.review_note

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val fragmentManager: FragmentManager = supportFragmentManager
    private var fragmentNote: NoteFragment = NoteFragment()
    private var fragmentShop: ShopFragment = ShopFragment()
    private var fragmentHome : HomeFragment = HomeFragment()
    private var fragmentRanking: RankingFragment = RankingFragment()
    private var fragmentTimer: TimerFragment = TimerFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chip_navigation.setOnItemSelectedListener { id ->
            when (id) {
                R.id.home -> view_pg.currentItem = 0
                R.id.shop -> view_pg.currentItem = 1
                R.id.note -> view_pg.currentItem = 2
                R.id.ranking -> view_pg.currentItem = 3
                R.id.timer -> view_pg.currentItem = 4
            }
        }

        view_pg.setOnTouchListener(View.OnTouchListener{v, event->true})
        view_pg.adapter = NavigationViewPagerAdapter(supportFragmentManager).apply {
            list = ArrayList<String>().apply {
                add("Home")
                add("Shop")
                add("Note")
                add("Ranking")
                add("Timer")
            }
        }

    }
    private fun getColors():IntArray{
        return intArrayOf(
            ContextCompat.getColor(this, R.color.navigation_color_mood),
            ContextCompat.getColor(this, R.color.navigation_color_habit),
            ContextCompat.getColor(this, R.color.navigation_color_add),
            ContextCompat.getColor(this, R.color.navigation_color_chart),
            ContextCompat.getColor(this, R.color.navigation_color_profile))
    }
}

