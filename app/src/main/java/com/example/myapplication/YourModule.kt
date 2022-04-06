package com.example.myapplication

import dagger.Module
import dagger.Provides

@Module(includes = [MyModule::class])
class YourModule {
    @Provides
    fun provideInt() = 11
}