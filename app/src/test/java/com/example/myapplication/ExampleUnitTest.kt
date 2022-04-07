package com.example.myapplication

import com.example.myapplication.components.DaggerMyComponent
import com.example.myapplication.components.DaggerPersonComponent
import com.example.myapplication.modules.PersonModule
import org.junit.Assert.assertEquals
import org.junit.Test

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

//    @Test
//    fun testInjections() {
//        val personA = DaggerPersonComponent.create().getPersonA()
//        println("✅ " + personA.name + " : " + personA.age)
//
//        val personB = PersonB()
//        DaggerPersonComponent.create().load(personB)
//        assertEquals(personB.name, "Charles")
//        assertEquals(personB.getAge(), 100)
//    }
//
//    @Test
//    fun testInheritance() {
//        val child = Child()
//        DaggerPersonComponent.create().load(child)
//        // todo 10 - 상속시 주입
//        assertEquals("Charles", child.name)
//        assertEquals("Charles", child.selfName)
//        assertEquals("", child.childName)
//    }

    @Test
    fun testComponentBuilder() {
        val self = Self()
        val component = DaggerPersonComponent.builder()
            .setModule(PersonModule())
            .setHeight(181.5f)
            .build()
        component.load(self)

        assertEquals(181.5f, self.height)
    }
}