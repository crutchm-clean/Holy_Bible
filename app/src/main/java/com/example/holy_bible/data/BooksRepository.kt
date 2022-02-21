package com.example.holy_bible.data

import com.example.holy_bible.data.cache.BooksCacheDataSource
import com.example.holy_bible.data.cache.BooksCacheMapper
import java.lang.Exception

interface BooksRepository {

    suspend fun fetchBooks() : BooksData

    class Base(
        private val cloudDataSource: BooksCloudDataSource,
        private val booksCloudMapper:BooksCloudMapper,
        private val cacheDataSource: BooksCacheDataSource,
        private val booksCacheMapper: BooksCacheMapper
        ): BooksRepository{
        override suspend fun fetchBooks() = try{
            val booksCacheList = cacheDataSource.fetchBooks()
            if(booksCacheList.isEmpty()){
                val booksCloudList = cloudDataSource.fetchBooks()
                val books = booksCloudMapper.map(booksCloudList)
                cacheDataSource.saveBooks(books)

                BooksData.Success(books)
            } else{
                BooksData.Success(booksCacheMapper.map(booksCacheList))
            }
        } catch (e: Exception){ BooksData.Fail(e) }
    }
}