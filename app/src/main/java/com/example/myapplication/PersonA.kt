package com.example.myapplication

import javax.inject.Inject

// todo 8 - var? val? 생성자 위치?
class PersonA @Inject constructor(val name: String, var age: Int)