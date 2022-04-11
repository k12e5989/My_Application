package com.example.myapplication

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Named

@Component(modules = [NamedModule::class])
interface NamedComponent {
//    @Named("hello")
//    fun getHello(): String

//    @Named("world")
//    fun getWorld(): String

    fun inject(concrete: NamedConcrete)
    fun getConcrete(): NamedConcrete
}

@Module
class NamedModule {
    @Provides
    @Named("hello")
    fun provideHello() = "hello"

    @Provides
    @Named("world")
    fun provideWorld() = "world"
}

class NamedConcrete @Inject constructor(@Named("hello") val hello: String, @Named("world") val world: String)