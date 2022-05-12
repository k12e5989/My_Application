package com.example.myapplication.ui.main

import android.content.SharedPreferences
import android.os.Bundle
import com.example.myapplication.MainActivityComponent
import com.example.myapplication.MainFragment
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class MainActivity : DaggerAppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject lateinit var sharedPref: SharedPreferences
    @Inject lateinit var activityString: String
    lateinit var component: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()
    }
}