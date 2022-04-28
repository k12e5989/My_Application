package com.example.myapplication

import dagger.Component
import dagger.Module
import dagger.Provides
import dagger.Subcomponent
import javax.inject.Inject

class Water

@Component(modules = [CafeModule::class])
interface CafeComponent {
    fun inject(cafe: Cafe): Unit
}

@Module(subcomponents = [MachineComponent::class])
class CafeModule {
    @Provides fun provideWater() = Water()
    @Provides fun provideMachine(builder: MachineComponent.Builder) = Machine(builder)
}

class Cafe {
    init {
        DaggerCafeComponent.create().inject(this)
    }
    @Inject lateinit var coffeeMachine: Machine
    fun orderCoffee() = coffeeMachine.extract()
}

class Coffee @Inject constructor(val coffeeBean: CoffeeBean, val water: Water)
class CoffeeBean

@Subcomponent(modules = [MachineModule::class])
interface MachineComponent {
    fun getCoffee(): Coffee // 생성자 주입, p.48
    fun inject(machine: Machine): Unit

    @Subcomponent.Builder
    interface Builder {
        fun build(): MachineComponent // p.51 세터 메서드 없어도 되네??
    }
}

@Module
class MachineModule {
    @Provides fun provideCoffeeBean() = CoffeeBean()
}

class Machine(builder: MachineComponent.Builder) {
    val component: MachineComponent = builder.build()
    init {
        component.inject(this)
    }
    fun extract() = component.getCoffee()
}