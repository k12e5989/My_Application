package com.example.myapplication

import dagger.Component
import dagger.MapKey
import dagger.Module
import dagger.Provides
import dagger.multibindings.ClassKey
import dagger.multibindings.IntoMap
import dagger.multibindings.StringKey
import kotlin.reflect.KClass

class FooMap

@Component(modules = [MapModule::class])
interface MapComponent {
    fun getLongsByString(): Map<String, Long>
    fun getStringsByClass(): Map<Class<*>, String>
}

@Module
class MapModule {
    @Provides
    @IntoMap
    @StringKey("foo")
    fun provideFooValue() = 100L

    @Provides
    @IntoMap
    @ClassKey(FooMap::class)
    fun provideFooStr() = "Foo String"
}

//--------------------------------------------------------

enum class Animal { CAT, DOG }

@MapKey
annotation class AnimalKey(val key: Animal)

@MapKey
annotation class NumberKey(val key: KClass<out Number>)

@Component(modules = [CustomMapModule::class])
interface MapKeyComponent {
    fun getStringsByAnimal(): Map<Animal, String>
    fun getStringsByNumber(): Map<Class<out Number>, String>
}

@Module
class CustomMapModule {
    @Provides @IntoMap @AnimalKey(Animal.CAT)
    fun provideCat() = "Meow"

    @Provides @IntoMap @AnimalKey(Animal.DOG)
    fun provideDog() = "Bow-wow"

    @Provides @IntoMap @NumberKey(Float::class)
    fun provideFloatString() = "100f"

    @Provides @IntoMap @NumberKey(Int::class)
    fun provideIntegerString() = "1"
}