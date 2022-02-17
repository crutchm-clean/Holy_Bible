package com.example.holy_bible.data

import com.example.holy_bible.data.net.BookServerModel
import com.example.holy_bible.data.net.BooksService

interface BooksCacheDataSource {
    suspend fun fetchBooks() : List<BookServerModel>

    class Base(private val service: BooksService) : BooksCacheDataSource{
        override suspend fun fetchBooks() = service.fetchBooks()
    }
}