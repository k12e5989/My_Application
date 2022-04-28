package com.example.myapplication

import org.junit.Test

class `12_Multi_Binding_Abstract` {
    @Test
    fun testMultibinds() {
        println("Parent: ")
        DaggerMultibindsComponent.create().getStrings().forEach { println(it) }
    }

    @Test
    fun testMultibindsWithSubcomponent() {
        println("Child: ")
        DaggerMultibindsComponent.create()
            .childCompBuilder()
            .build()
            .getStrings()
            .forEach { println(it) }

    }
}