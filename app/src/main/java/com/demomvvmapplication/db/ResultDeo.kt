package com.mvvmdemo.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.demomvvmapplication.data.network.model.Result


@Dao
interface ResultDeo {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     fun saveAllResult(quotes: List<Result>)

    @Query("SELECT * FROM Result")
    fun getResult(): LiveData<List<Result>>

}