package com.example.myapplication

import dagger.Component

@Component(modules = [PersonModule::class])
interface PersonComponent {
    fun getPersonA(): PersonA

    fun inject(personB: PersonB)
}