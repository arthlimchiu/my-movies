package com.arthlimchiu.mymovies.di

import com.arthlimchiu.mymovies.movies.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        RepositoryModule::class,
        ViewModelModule::class
    ]
)
interface AppComponent {

    fun inject(activity: MainActivity)
}