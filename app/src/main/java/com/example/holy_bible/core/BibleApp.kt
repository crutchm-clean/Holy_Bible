package com.example.holy_bible.core

import android.app.Application
import com.example.holy_bible.data.BooksCloudDataSource
import com.example.holy_bible.data.BooksCloudMapper
import com.example.holy_bible.data.BooksRepository
import com.example.holy_bible.data.cache.BookCacheMapper
import com.example.holy_bible.data.cache.BooksCacheDataSource
import com.example.holy_bible.data.cache.BooksCacheMapper
import com.example.holy_bible.data.cache.RealmProvider
import com.example.holy_bible.data.net.BookCloudMapper
import com.example.holy_bible.data.net.BooksService
import retrofit2.Retrofit

class BibleApp : Application() {
    override fun onCreate() {
        super.onCreate()

        val retrofit = Retrofit.Builder()
            .baseUrl("https://bible-go-api.rkeplin.com/v1/")
            .build()
        val service = retrofit.create(BooksService::class.java)

        val cloudDataSource = BooksCloudDataSource.Base(service)
        val cacheDataSource = BooksCacheDataSource.Base(RealmProvider.Base())

        val booksCloudMapper = BooksCloudMapper.Base(BookCloudMapper.Base())
        val booksCacheMapper = BooksCacheMapper.Base(BookCacheMapper.Base())
        val booksRepository = BooksRepository.Base(
            cloudDataSource,
            booksCloudMapper,
            cacheDataSource,
            booksCacheMapper
        )
    }
}