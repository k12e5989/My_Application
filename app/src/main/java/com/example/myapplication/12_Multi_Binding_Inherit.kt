package com.example.myapplication

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import dagger.multibindings.IntoSet

@Component(modules = [ParentModule::class, GrandparentModule::class])
interface ParentComponent {
    fun strings(): Set<String>
    fun childCompBuilder(): ChildComponent.Builder
}

@Module
class GrandparentModule {
    @Provides @IntoSet fun string1() = "Grandpa"
    @Provides @IntoSet fun string2() = "Grandma"
}

@Module(subcomponents = [ChildComponent::class])
class ParentModule {
    @Provides @IntoSet fun string1() = "parent string 1"
    @Provides @IntoSet fun string2() = "parent string 2"
}

@Subcomponent(modules = [ChildModule::class])
interface ChildComponent {
    fun strings(): Set<String>

    @Subcomponent.Builder
    interface Builder {
        fun build(): ChildComponent
    }
}

@Module
class ChildModule {
    @Provides @IntoSet fun string3() = "child string 1"
    @Provides @IntoSet fun string4() = "child string 2"
}