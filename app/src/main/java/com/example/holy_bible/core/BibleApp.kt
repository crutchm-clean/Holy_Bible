package com.example.holy_bible.core

import android.app.Application
import com.example.holy_bible.data.net.BooksService
import retrofit2.Retrofit

class BibleApp : Application() {
    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://bible-go-api.rkeplin.com/v1/")
            .build()
        val service = retrofit.create(BooksService::class.java)
    }
}