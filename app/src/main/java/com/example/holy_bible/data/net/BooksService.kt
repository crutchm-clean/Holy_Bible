package com.example.holy_bible.data.net

import retrofit2.http.GET

interface BooksService {
    @GET("books")
    suspend fun fetchBooks() : List<BookCloud>
}

