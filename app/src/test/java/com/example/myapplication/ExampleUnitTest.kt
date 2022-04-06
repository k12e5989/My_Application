package com.example.myapplication

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun testHelloWorld() {
        val myComponent = DaggerMyComponent.create()
        // todo 5 - 테스트 실행해보자
        System.out.println("✅ result = " + myComponent.getString() + myComponent.getInt())
    }
}