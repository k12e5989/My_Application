package com.example.myapplication

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.IntoSet
import dagger.multibindings.Multibinds

@Component(modules = [MultibindsModule::class])
interface MultibindsComponent {
    fun getStrings(): Set<String>
    fun childCompBuilder(): MultibindsSubComponent.Builder
}

@Module(subcomponents = [MultibindsSubComponent::class])
abstract class MultibindsModule {
    @Multibinds // must be abstract
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
    @IntoSet // 오류 원인. run with stacktrace 도움
    fun strings(): Set<String> = setOf("str 1", "str 2")
}