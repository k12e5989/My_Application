package com.example.myapplication.concrete

import javax.inject.Inject

open class Self : Parent() {
    var selfName: String = ""
        @Inject set

    var height: Float = 0f
        @Inject set
}