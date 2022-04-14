package com.example.myapplication

import org.junit.Test

class NamedTest {
    @Test
    fun test() {
        println(DaggerNamedComponent.create().getConcrete().hello)
        println(DaggerNamedComponent.create().getConcrete().world)
    }
}