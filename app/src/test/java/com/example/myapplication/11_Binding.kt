package com.example.myapplication

import org.junit.Test

class BindingTest {
    @Test
    fun testBinding() {
        println("getString(): ${DaggerBindingComponent.create().getString()}")
        println("getCharSequence(): ${DaggerBindingComponent.create().getCharSequence()}")
    }

    @Test
    fun testBindsOptionalOf() {
        val foo = Foo()
        DaggerStrComponent.create().inject(foo)

        println("foo.optional.isPresent: ${foo.optional.isPresent}")
        println("foo.optionalP.isPresent: ${foo.optionalP.isPresent}")
        println("foo.optionalL.isPresent: ${foo.optionalL.isPresent}")

//        println("foo.nullable: ${foo.nullable}")
//        println("foo.nullableP?.get(): ${foo.nullableP?.get()}")
//        println("foo.nullableL?.get(): ${foo.nullableL?.get()}")
    }
}