package com.example.myapplication.concrete

import javax.inject.Inject

class MyClass {
    // todo 6 - 에러
    // var 이어야 주입 가능
    // error: Dagger does not support injection into private fields
    //    private java.lang.String str = "default";
//    @Inject
//    var str: String = "default"
    var str: String? = ""
        @Inject set

//    lateinit var any: Any
//        @Inject set
}