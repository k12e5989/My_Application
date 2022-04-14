package com.example.myapplication

import dagger.Component
import dagger.Lazy
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Provider

@Component(modules = [CounterModule::class])
interface CounterComponent {
    fun inject(counterLazy: CounterLazy)
    fun inject(counterProvider: CounterProvider)
}

@Module
class CounterModule {
    var next = 100

    @Provides
    fun provideInteger(): Int {
        println("computing...")
        return next++
    }
}

class CounterLazy {
    @Inject
    lateinit var lazy: Lazy<Int>

    fun printLazy() {
        println("printing...")
        println(lazy.get())
        println(lazy.get())
        println(lazy.get())
    }
}

class CounterProvider {
    @Inject
    lateinit var lazy: Provider<Int>

    fun printProvider() {
        println("printing...")
        println(lazy.get())
        println(lazy.get())
        println(lazy.get())
    }
}