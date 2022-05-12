package com.example.myapplication

import android.content.Context
import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerFragment
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

class MainFragment : DaggerFragment() {
    @Inject lateinit var appString: String

    override fun onAttach(context: Context) {
        Log.d(MainFragment::class.simpleName, appString)
        super.onAttach(context)
    }
}