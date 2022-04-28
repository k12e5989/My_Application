package com.example.myapplication

import dagger.Component
import dagger.Module
import dagger.Provides

@Module
class moduleA {
    @Provides
    fun provideString() = "A"
}

@Module
class moduleB {
    @Provides
    fun provideString() = "B"
}

@Component(modules = [moduleA::class, moduleB::class])
interface playComponent {
    fun getString(): String
    @Component.Builder
    interface Builder {
        fun setModule()
    }
}