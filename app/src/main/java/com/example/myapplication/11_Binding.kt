package com.example.myapplication

import dagger.*
import java.util.*
import javax.inject.Inject
import javax.inject.Provider

@Module
abstract class BindingModule {
    companion object {
        @Provides
        fun provideString() = "string"
    }

    @Binds
    abstract fun provideCharSequence(string: String): CharSequence
}

@Component(modules = [BindingModule::class])
interface BindingComponent {
    fun getString(): String
    fun getCharSequence(): CharSequence
}

// --------------------------------------------------------------------

@Module
abstract class BindsOptionalOfModule {
    @BindsOptionalOf
    abstract fun bindsOptionalOfString(): String
}

@Module
class BindsStringModule {
    @Provides
    fun provideString() = "나는 문자열"
}

class Foo {
    lateinit var optional: Optional<String>
        @Inject set

    lateinit var optionalP: Optional<Provider<String>>
        @Inject set

    lateinit var optionalL: Optional<Lazy<String>>
        @Inject set

//    var nullable: String? = null
//        @Inject set
//
//    var nullableP: Provider<String>? = null
//        @Inject set
//
//    var nullableL: Lazy<String>? = null
//        @Inject set
}

//@Component(modules = [BindsOptionalOfModule::class, BindsStringModule::class])
@Component(modules = [BindsOptionalOfModule::class])
interface StrComponent {
    fun inject(foo: Foo)
}

// ------------------------------------------------------------------------