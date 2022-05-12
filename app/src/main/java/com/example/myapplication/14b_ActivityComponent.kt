package com.example.myapplication

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Inject

@Subcomponent(modules = [MainActivityModule::class])
@ActivityScope // scope annotation
interface MainActivityComponent {
    fun mainFragmentComponentBuilder(): MainFragmentComponent.Builder
    fun inject(activity: MainActivity)

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun setActivity(activity: MainActivity): Builder
        fun build(): MainActivityComponent
    }
}

@Module(subcomponents = [MainFragmentComponent::class])
class MainActivityModule {
    @Provides
    @ActivityScope
    fun provideActivityName(): String = MainActivity::class.simpleName!!
}

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var sharePreferences: SharedPreferences // app에서 상속
    @Inject
    lateinit var activityName: String
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