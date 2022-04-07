package com.example.myapplication

import javax.inject.Inject

open class Self : Parent() {
    var selfName: String = ""
    @Inject set
}