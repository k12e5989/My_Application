package com.example.myapplication.modules

import dagger.Module
import dagger.Provides

@Module(includes = [MyModule::class])
class YourModule {
    @Provides
    fun provideInt() = 11
}