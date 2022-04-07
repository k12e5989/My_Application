package com.example.myapplication

import javax.inject.Inject

open class Child : Self() {
    var childName: String = ""
        @Inject set
}