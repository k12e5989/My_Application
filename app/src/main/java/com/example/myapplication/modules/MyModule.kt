package com.example.myapplication.modules

import dagger.Module
import dagger.Provides

@Module // 의존성을 제공하는 클래스
class MyModule {
    @Provides // 의존성을 제공하는 메서드
    fun provideHelloWorld() = "Hello "
}