package com.example.myapplication

import android.content.Context
import android.util.Log
import androidx.fragment.app.Fragment
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import javax.inject.Named

@FragmentScope
@Subcomponent(modules = [MainFragmentModule::class])
interface MainFragmentComponent : AndroidInjector<MainFragment> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainFragment>
}

@Module
class MainFragmentModule {
    @Named("fragment") @Provides @FragmentScope fun provideString() = "String from fragment"
}

class MainFragment : Fragment() {
    @Inject @Named("app") lateinit var appString: String
    @Inject @Named("activity") lateinit var activityString: String
    @Inject @Named("fragment") lateinit var fragmentString: String

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        Log.d(MainFragment::class.simpleName, appString)
        Log.d(MainFragment::class.simpleName, activityString)
        Log.d(MainFragment::class.simpleName, fragmentString)

        super.onAttach(context)
    }
}