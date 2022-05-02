package com.example.myapplication

import android.app.Application
import android.content.Context
import com.example.myapplication.ui.main.MainActivity
import dagger.*
import javax.inject.Scope
import javax.inject.Singleton

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class ActivityScope

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class FragmentScope

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {
    fun mainActivityComponentBuilder(): MainActivityComponent.Builder
    fun inject(app: App)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App, appModule: AppModule): AppComponent
    }
}

@Module(subcomponents = [MainActivityComponent::class])
class AppModule {
    @Provides
    @Singleton
    fun provideSharedPreferences(app: App) = app.getSharedPreferences(
        "default",
        Context.MODE_PRIVATE
    )
}

class App : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.factory().create(this, AppModule())
    }
}
// =============================================================================
@Subcomponent(modules = [MainActivityModule::class])
@ActivityScope
interface MainActivityComponent {
    fun mainFragmentComponentBuilder(): MainFragmentComponent.Builder
    fun inject(activity: MainActivity)

    @Subcomponent.Builder
    interface Builder {
        @BindsInstance fun setActivity(activity: MainActivity): Builder
        fun build(): MainActivityComponent
    }
}

@Module(subcomponents = [MainFragmentComponent::class])
class MainActivityModule {
    @Provides
    @ActivityScope
    fun provideActivityName(): String = MainActivity::class.simpleName!!
}