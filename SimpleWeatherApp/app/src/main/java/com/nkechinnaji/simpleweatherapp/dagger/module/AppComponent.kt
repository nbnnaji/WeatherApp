package com.nkechinnaji.simpleweatherapp.dagger.module

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {
}