package com.example.myapplication

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides
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
    fun inject(app: App) // 안 쓴다.

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance app: App, appModule: AppModule): AppComponent
    }
}

@Module(subcomponents = [MainActivityComponent::class])
class AppModule {
    @Provides
    @Singleton
    fun provideSharedPreferences(app: App): SharedPreferences = app.getSharedPreferences(
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