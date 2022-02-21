package com.example.holy_bible.data.cache

import com.example.holy_bible.core.Abstract
import com.example.holy_bible.core.Book

interface BookCacheMapper : Abstract.Mapper {

    fun map(bookDb: BookDb) : Book


    class Base(): BookCacheMapper{
        override fun map(bookDb: BookDb) = Book(bookDb.id, bookDb.name)
    }
}
