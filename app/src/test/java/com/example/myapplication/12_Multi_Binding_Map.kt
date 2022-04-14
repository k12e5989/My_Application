package com.example.myapplication

import org.junit.Test

class `12_Multi_Binding_Map` {
    @Test
    fun testMultibindingMap() {
        val component = DaggerMapComponent.create()
        println(component.getLongsByString()["foo"])
        println(component.getStringsByClass()[FooMap::class.java])
    }

    //--------------------------------------------------------

    @Test
    fun testCustomMapKey() {
        DaggerMapKeyComponent.create().let {
            println(it.getStringsByAnimal()[Animal.CAT])
            println(it.getStringsByAnimal()[Animal.DOG])
            println(it.getStringsByNumber()[Float::class.java])
        }
    }
}