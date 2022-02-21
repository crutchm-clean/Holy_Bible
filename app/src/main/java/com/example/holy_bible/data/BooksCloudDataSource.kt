package com.example.holy_bible.data

import com.example.holy_bible.data.net.BookCloud
import com.example.holy_bible.data.net.BooksService

interface BooksCloudDataSource {
    suspend fun fetchBooks() : List<BookCloud>

    class Base(private val service: BooksService) : BooksCloudDataSource{
        override suspend fun fetchBooks() = service.fetchBooks()
    }
}