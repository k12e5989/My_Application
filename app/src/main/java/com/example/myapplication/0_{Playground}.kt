package com.example.myapplication

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoSet

@Module
class ModuleA {
    @Provides
    @IntoSet
    fun provideString() = "A"
}

@Module
class ModuleB {
    @Provides
    @IntoSet
    fun provideString() = "B"
}

@Component(modules = [ModuleA::class, ModuleB::class])
interface PlayComponent {
    fun getStrings(): Set<String>
    @Component.Builder
    interface Builder {
        fun setModule(): PlayComponent
    }
}