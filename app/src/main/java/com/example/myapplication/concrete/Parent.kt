package com.example.myapplication.concrete

import javax.inject.Inject

open class Parent {
    var name: String = ""
    @Inject set
}