package com.example.myapplication.ui.main

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.App
import com.example.myapplication.MainActivityComponent
import com.example.myapplication.MainFragment
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject lateinit var sharePreferences: SharedPreferences // app에서 상속
    @Inject lateinit var activityName: String
    lateinit var component: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        component = (application as App).appComponent
            .mainActivityComponentBuilder()
            .setActivity(this)
            .build()
        component.inject(this)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()
    }
}