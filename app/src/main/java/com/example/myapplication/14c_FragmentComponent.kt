package com.example.myapplication

import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import androidx.fragment.app.Fragment
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
    fun self(): MainFragment

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance
        fun setFragment(fragment: MainFragment): Builder
        fun build(): MainFragmentComponent
    }
}

@Module
class MainFragmentModule {
    @Provides @FragmentScope fun provideInt() = Random().nextInt()
}

class MainFragment : Fragment() {
    @Inject
    lateinit var sharedPreferences: SharedPreferences
    @Inject
    lateinit var activityName: String
    var randomNumber: Int = 0
        @Inject set

    override fun onAttach(context: Context) {
        super.onAttach(context)
        lateinit var component: MainFragmentComponent // DaggerMainFragmentComponent 없다

        if (activity is MainActivity) {
            component = (activity as MainActivity).component
                .mainFragmentComponentBuilder()
                .setFragment(this)
                .build()
            component.inject(this)
        }
        Log.d(MainFragment::class.simpleName, activityName)
        Log.d(MainFragment::class.simpleName, "randomNumber = $randomNumber")
        Log.d(MainFragment::class.simpleName, "SAME? - ${component.self() == this}")
    }
}