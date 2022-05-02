package com.example.myapplication

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.Multibinds

@Component(modules = [MultibindsModule::class])
interface MultibindsComponent {
    fun getStrings(): Set<String>
    fun childCompBuilder(): MultibindsSubComponent.Builder
}

@Module(subcomponents = [MultibindsSubComponent::class])
abstract class MultibindsModule {
    @Multibinds
    abstract fun strings(): Set<String>
}

@Subcomponent(modules = [MultibindsSubmodule::class])
interface MultibindsSubComponent {
    fun getStrings(): Set<String>

    @Subcomponent.Builder
    interface Builder {
        fun build(): MultibindsSubComponent
    }
}

@Module
class MultibindsSubmodule {
    @Provides
    fun strings(): Set<String> = setOf("str 1", "str 2")
}