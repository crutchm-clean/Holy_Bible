package com.example.holy_bible.data.cache

import com.example.holy_bible.core.Abstract
import com.example.holy_bible.core.Book

interface BooksCacheMapper: Abstract.Mapper {

    fun map(books: List<BookDb>) : List<Book>

    class Base(private val mapper: BookCacheMapper): BooksCacheMapper {
        override fun map(books: List<BookDb>): List<Book> = books.map{
            bookDb -> bookDb.map(mapper)
        }
    }
}