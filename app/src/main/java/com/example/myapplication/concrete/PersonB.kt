package com.example.myapplication.concrete

import javax.inject.Inject

class PersonB {
    var name: String = ""
        @Inject set

    private var age: Int = -1

    @Inject fun setA(age: Int) {
        this.age = age
    }

    fun getAge() = age
}