package com.example.myapplication

import android.content.Context.MODE_PRIVATE
import com.example.myapplication.ui.main.MainActivity
import dagger.*
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
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

        @Provides
        @Singleton
        fun sf(app: App) = app.getSharedPreferences("default", MODE_PRIVATE)
    }

    @Binds @IntoMap @ClassKey(MainActivity::class)
    abstract fun bindAndroidInjectorFactory(factory: MainActivityComponent.Factory): AndroidInjector.Factory<*>
}

class App : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> = DaggerAppComponent.factory().create(this)
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

        @Provides
        fun str() = "Activity String"
    }

    @Binds @IntoMap @ClassKey(MainFragment::class)
    abstract fun bindAndroidInjectorFactory(factory: MainFragmentComponent.Factory): AndroidInjector.Factory<*>

}