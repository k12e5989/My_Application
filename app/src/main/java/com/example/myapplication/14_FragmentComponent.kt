package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.fragment.app.Fragment
import com.example.myapplication.ui.main.MainActivity
import dagger.BindsInstance
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import java.util.*
import javax.inject.Inject

@FragmentScope
@Subcomponent(modules = [MainFragmentModule::class])
interface MainFragmentComponent {
    fun inject(mainFragment: MainFragment)

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun setFragment(fragment: MainFragment): MainFragmentComponent.Builder
        fun build(): MainFragmentComponent
    }
}

@Module
class MainFragmentModule {
    @Provides @FragmentScope fun provideInt() = Random().nextInt()
}

class MainFragment : Fragment() {
    @Inject lateinit var sharedPreferences: SharedPreferences
    @Inject lateinit var activityName: String
    var randomNumber: Int = 0
        @Inject set

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (activity is MainActivity) {
            (activity as MainActivity).component
                .mainFragmentComponentBuilder()
                .setFragment(this)
                .build().inject(this)
        }
        Log.d(MainFragment::class.simpleName, activityName)
        Log.d(MainFragment::class.simpleName, "randomNumber = $randomNumber")
    }
}