package com.example.basic.di

import com.example.basic.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBindingModule {
    @ContributesAndroidInjector
    abstract fun binMainActivity() : MainActivity
}