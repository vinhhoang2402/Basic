package com.example.basic.di

import com.example.basic.BasicApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton


@Component(modules = [
    AndroidInjectionModule::class,
    AppModule::class,
    ActivityBindingModule::class
])
interface AppComponent : AndroidInjector<BasicApp> {
    @Component.Builder
    interface Builder{
        @BindsInstance
        fun application(app: BasicApp): Builder

        fun build(): AppComponent
    }
}