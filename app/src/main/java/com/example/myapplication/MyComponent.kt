package com.example.myapplication

import dagger.Component
import dagger.MembersInjector
import javax.inject.Singleton

@Singleton
@Component(modules = [YourModule::class]) // todo 6 - 컴포넌트 > 모듈?
interface MyComponent {
    // todo 4 - 반환형 명시해야 함!
    // 프로비전 메서드: 매개 변수 없고 모듈로부터 반환형 주입됨
    fun getString(): String
    fun getInt(): Int

    fun inject(myClass: MyClass)
    // todo 8 - generic 주입자 메서드: Any로는 안되네 ㅠ
    fun getInjector(): MembersInjector<MyClass>
}