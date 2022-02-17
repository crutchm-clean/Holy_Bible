package com.example.holy_bible.data

import java.lang.Exception

interface BooksRepository {

    suspend fun fetchBooks() : BookData

    class Base(private val cacheDataSource: BooksCacheDataSource): BooksRepository{
        override suspend fun fetchBooks() = try{
                BookData.Success(cacheDataSource.fetchBooks())
            } catch (e: Exception){ BookData.Fail(e) }
    }
}