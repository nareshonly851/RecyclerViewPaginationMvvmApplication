package com.demomvvmapplication

import android.app.Application
import com.demomvvmapplication.auth.AuthViewModelFactory
import com.demomvvmapplication.data.network.MyApi

import com.demomvvmapplication.gif.GifViewModelFactory
import com.mvvmdemo.data.db.AppDatabase
import com.mvvmdemo.data.repositories.GifRepository
import com.mvvmdemo.data.repositories.UserRepository


import org.kodein.di.Kodein
import org.kodein.di.KodeinAware

import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.singleton

class MvvmApplication : Application(),KodeinAware {



    override val kodein = Kodein.lazy {
        import(androidXModule(this@MvvmApplication))


        bind() from singleton { AuthViewModelFactory(instance()) }
        bind() from singleton { AppDatabase(instance()) }
        bind() from singleton { GifRepository(instance(),instance()) }
        bind() from singleton { GifViewModelFactory(instance()) }
        bind() from singleton { UserRepository(instance()) }
        bind() from singleton { MyApi() }


    }
}

