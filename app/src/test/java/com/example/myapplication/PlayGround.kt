package com.example.myapplication

import org.junit.Test

class PlayGround {
    @Test fun testInject() {
        val injectee = Injectee()
        DaggerInjectTestComponent.create().injact(injectee)
        println(injectee.name)
    }
}