package com.example.myapplication

import org.junit.Test

class ScopeTest {
    @Test
    fun testSingleton() {
        val component1 = DaggerSingletonComponent.create()
        val component2 = DaggerSingletonComponent.create()
        val any1 = component1.getAny()
        val any2 = component1.getAny()

        println("component1 - $component1")
        println("component2 - $component2")
        println("any1 - $any1")
        println("any2 - $any2")
        println("getHello() - ${component1.getHello()}")
        println("getAwesome() - ${component1.getAwesome()}")
    }
}