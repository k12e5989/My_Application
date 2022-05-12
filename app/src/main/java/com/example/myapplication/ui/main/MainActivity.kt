package com.example.myapplication.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.MainActivityComponent
import com.example.myapplication.MainFragment
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityMainBinding
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject
import javax.inject.Named

class MainActivity : AppCompatActivity(), HasAndroidInjector {
    private lateinit var binding: ActivityMainBinding

    @Inject lateinit var androidInjector: DispatchingAndroidInjector<Any>
    @Inject @Named("app") lateinit var appName: String
    @Inject @Named("activity") lateinit var activityString: String
    lateinit var component: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MainFragment())
            .commit()
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}