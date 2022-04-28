package com.example.myapplication

import org.junit.Test

class `12_Multi_Binding_Inherit` {
    @Test
    fun testMultibindingWithSubComponent() {
        val parentComponent = DaggerParentComponent.create()
        println("Parent:")
        parentComponent.strings().forEach {
            println(it)
        }

        println("Child:")
        parentComponent.childCompBuilder().build().strings().forEach {
            println(it)
        }
    }
}