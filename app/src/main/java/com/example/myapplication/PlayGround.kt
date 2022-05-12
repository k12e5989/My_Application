package com.example.myapplication

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

//class Injectee @Inject constructor(val name: String)
class Injectee {
    @Inject lateinit var name: String
}

@Component(modules = [InjectTestModule::class])
interface InjectTestComponent {
    fun injact(injectee: Injectee)

    @Component.Factory
    interface Factory {
        fun create(): InjectTestComponent
    }
}

@Module
class InjectTestModule {
    @Provides fun str() = "NAAAAAAMEEEEE"
}