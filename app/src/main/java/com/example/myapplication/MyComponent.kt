package com.example.myapplication

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [YourModule::class]) // todo 6 - 컴포넌트 > 모듈?
interface MyComponent {
    // todo 4 - 반환형 명시해야 함!
    fun getString(): String
    fun getInt(): Int
}