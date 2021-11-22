package com.example.navigationfragmentfadhil

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.navigationfragmentfadhil.Fragment.HomeFragment
import com.example.navigationfragmentfadhil.Fragment.NotificationFragment
import com.example.navigationfragmentfadhil.Fragment.SettingsFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private val View.itemId: Any
    get() = Unit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val homeFragment = HomeFragment()
        val notificationFragment = NotificationFragment()
        val settingsFragment = SettingsFragment()

        makeCurrentFragment (homeFragment)

        val botton_navigation = findViewById<BottomNavigationView>(R.id.botton_navigation)

        botton_navigation.setOnClickListener {
            when(it.itemId) {
                R.id.menu_home -> makeCurrentFragment(homeFragment)
                R.id.menu_notification -> makeCurrentFragment(notificationFragment)
                R.id.menu_settings -> makeCurrentFragment(settingsFragment)
            }

            true
        }

    }

    private fun makeCurrentFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.frame_nav, fragment)
            commit()
        }

    }
}