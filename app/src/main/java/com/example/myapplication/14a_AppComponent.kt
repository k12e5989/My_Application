package com.example.myapplication

import android.app.Application
import com.example.myapplication.ui.main.MainActivity
import dagger.*
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Scope
import javax.inject.Singleton

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class ActivityScope

@Scope
@Retention(value = AnnotationRetention.RUNTIME)
annotation class FragmentScope

@Component(modules = [AppModule::class, AndroidInjectionModule::class])
@Singleton
interface AppComponent : AndroidInjector<App> {
    @Component.Factory
    interface Factory : AndroidInjector.Factory<App>
//    interface Factory : AndroidInjector.Builder<App>
}

@Module(subcomponents = [MainActivityComponent::class])
abstract class AppModule {
    companion object {
        @Named("app") @Provides @Singleton
        fun provideString() = "String from AppModule"
    }

    @Binds @IntoMap @ClassKey(MainActivity::class)
    abstract fun bindAndroidInjectorFactory(factory: MainActivityComponent.Factory): AndroidInjector.Factory<*>
}

class App : Application(), HasAndroidInjector {
    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.factory().create(this).inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> = dispatchingAndroidInjector
}
// =============================================================================
@Subcomponent(modules = [MainActivityModule::class])
@ActivityScope // scope annotation
interface MainActivityComponent : AndroidInjector<MainActivity> {
    @Subcomponent.Factory
    interface Factory : AndroidInjector.Factory<MainActivity>
}

@Module(subcomponents = [MainFragmentComponent::class])
abstract class MainActivityModule {
    companion object {
        @Named("activity") @Provides @ActivityScope
        fun provideActivityName(): String = "String from ${MainActivity::class.simpleName}"
    }

    @Binds @IntoMap @ClassKey(MainFragment::class)
    abstract fun bindAndroidInjectorFactory(factory: MainFragmentComponent.Factory): AndroidInjector.Factory<*>

}