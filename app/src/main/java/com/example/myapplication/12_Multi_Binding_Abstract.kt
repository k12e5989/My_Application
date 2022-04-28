package com.example.myapplication

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.Multibinds

@Module(subcomponents = [MultibindsSubComponent::class])
abstract class MultibindsModule {
    @Multibinds
    abstract fun strings(): Set<String>
//    @Provides @ElementsIntoSet
//    fun strings(): Set<String> = setOf("P string 1", "P string 2")
}

@Component(modules = [MultibindsModule::class])
interface MultibindsComponent {
    fun getStrings(): Set<String>
    fun childCompBuilder(): MultibindsSubComponent.Builder
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
    @ElementsIntoSet
    fun getStrings() = setOf("C string 1", "C string 2")
}