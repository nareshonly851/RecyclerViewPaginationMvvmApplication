package com.mvvmdemo.data.repositories


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.demomvvmapplication.data.network.MyApi
import com.demomvvmapplication.data.network.SafeApiRequest
import com.demomvvmapplication.data.network.model.Result
import com.mvvmdemo.data.db.AppDatabase
import com.mvvmdemo.util.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.time.LocalDateTime




class GifRepository(
    private val api: MyApi,
    private val db: AppDatabase

) : SafeApiRequest() {

    private val quotes = MutableLiveData<List<Result>>()

    init {
        quotes.observeForever {
            saveQuotes(it)
        }
    }

    suspend fun getQuotes(key: String, limit: Int): LiveData<List<Result>> {
        return withContext(Dispatchers.IO) {

            fetchQuotes(key,limit)
            db.getQuotedeo().getResult()

        }
    }

    private suspend fun fetchQuotes(key: String, limit: Int) {




            val response = apiRequest { api.getGif(key,limit) }
            quotes.postValue(response.results)

    }

    private fun isFetchNeeded(parse: LocalDateTime): Boolean {



        return true

    }

    private fun saveQuotes(quotes: List<Result>) {
        Coroutines.io {
            // prefs.saveLastSaveAt(LocalDateTime.now().toString())
            db.getQuotedeo().saveAllResult(quotes)
        }
    }


}






