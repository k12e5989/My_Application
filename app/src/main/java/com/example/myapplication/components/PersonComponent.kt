package com.example.myapplication.components

import com.example.myapplication.PersonA
import com.example.myapplication.PersonB
import com.example.myapplication.Self
import com.example.myapplication.modules.PersonModule
import dagger.Component

@Component(modules = [PersonModule::class])
interface PersonComponent {
    fun getPersonA(): PersonA // 프로비전 메서드

    fun load(personB: PersonB) // 멤버-인젝션 메서드

    fun load(self: Self)


}