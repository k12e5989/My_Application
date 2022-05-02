package com.example.myapplication

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.multibindings.ElementsIntoSet
import dagger.multibindings.IntoSet
import java.util.*
import javax.inject.Inject
import kotlin.collections.HashSet

@Module
class SetModule {
    @Provides
    @IntoSet
    fun provideHello() = "Hello"

    @Provides
    @IntoSet
    fun provideWorld() = "World"
}

@Component(modules = [SetModule::class])
interface SetComponent {
    fun getStrings(): Set<String>
}

@Module
class ElementsIntoSetModule {
    @Provides
    @ElementsIntoSet
    fun provideSet() = setOf("Charles", "Runa")
    //    }

    @Provides
    @ElementsIntoSet
    fun provideSet2() = setOf("a", "b")
}

@Component(modules = [ElementsIntoSetModule::class])
interface ElementsIntoSetComponent {
    fun inject(foo: FooMultiBinding)
}

class FooMultiBinding {
    lateinit var strings: Set<String>
        @Inject set
}