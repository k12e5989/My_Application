package com.example.myapplication

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Reusable
import java.lang.annotation.RetentionPolicy
import javax.inject.Qualifier
import javax.inject.Singleton

@Module
class SingletonModule {
    @Provides
//    @Singleton
    @Reusable
    fun provideAny() = Any()

    @Provides
    fun provideHello() = "hello"

    @Provides
    @Awesome
    fun provideAwesome() = "AWESOME"
}

//@Singleton
@Component(modules = [SingletonModule::class])
interface SingletonComponent {
    fun getAny(): Any

    fun getHello(): String

    @Awesome
    fun getAwesome(): String
}

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class Awesome