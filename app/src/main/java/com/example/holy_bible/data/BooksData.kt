package com.example.holy_bible.data

import com.example.holy_bible.core.Abstract
import com.example.holy_bible.core.Book
import com.example.holy_bible.data.net.BookCloud
import com.example.holy_bible.domain.BookDomain
import java.lang.Exception

sealed class BooksData : Abstract.Object<BookDomain, BooksDataToDomainMapper>(){
    class Success(private val books: List<Book>) : BooksData() {
        override fun map(mapper: BooksDataToDomainMapper) = mapper.map(books)

    }

    class Fail(private val e:Exception) : BooksData(){
        override fun map(mapper: BooksDataToDomainMapper) = mapper.map(e)

    }



//    class Success(private val books: List<BookServerModel>) : BookData{}
}