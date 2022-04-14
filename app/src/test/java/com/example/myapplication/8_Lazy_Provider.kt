package com.example.myapplication

import com.example.myapplication.components.DaggerMyComponent
import com.example.myapplication.components.DaggerPersonComponent
import com.example.myapplication.concrete.MyClass
import com.example.myapplication.concrete.Self
import com.example.myapplication.modules.PersonModule
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class `8_Lazy_Provider` {
    @Test
    fun testLazyProvider() {
        val lazy = CounterLazy()
        val provider = CounterProvider()
        DaggerCounterComponent.create().inject(lazy)
        DaggerCounterComponent.create().inject(provider)

        lazy.printLazy()
        println("------------")
        provider.printProvider()
    }
}