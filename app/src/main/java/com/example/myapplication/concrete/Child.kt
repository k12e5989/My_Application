package com.example.myapplication.concrete

import javax.inject.Inject

open class Child : Self() {
    var childName: String = ""
        @Inject set
}