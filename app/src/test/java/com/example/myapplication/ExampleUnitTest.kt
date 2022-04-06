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
        // todo 5 - 테스트 실행해보자 / 생성된 컴포넌트 열어보자
        System.out.println("✅ result = " + myComponent.getString() + myComponent.getInt())
    }

    @Test
    fun testMemberInjection() {
        val myClass = MyClass()
        assertEquals("", myClass.str)

        val myComponent = DaggerMyComponent.create()
        // todo 7 - 누가 누구한테 주입하지? inject() 기능을 누가 갖고 있는지 보자.
        myComponent.inject(myClass)
        assertEquals("Hello ", myClass.str)
    }

    @Test
    fun testMemberInjector() {
        val myClass = MyClass()
        println("✅ " + myClass.str)

        val myComponent = DaggerMyComponent.create()
        myComponent.getInjector().injectMembers(myClass)
        println("✅ " + myClass.str)
    }

    @Test
    fun testInjections() {
        val personA = DaggerPersonComponent.create().getPersonA()
        println("✅ " + personA.name + " : " + personA.age)

        val personB = PersonB()
        DaggerPersonComponent.create().inject(personB)
        assertEquals(personB.name, "Charles")
        assertEquals(personB.getAge(), 100)
    }
}