package com.example.myapplication

import dagger.Module
import dagger.Provides

@Module
class PersonModule {

    @Provides
    fun provideName() = "Charles"

    @Provides
    fun provideAge() = 100
}
