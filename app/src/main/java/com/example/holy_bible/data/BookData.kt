package com.example.holy_bible.data

import com.example.holy_bible.core.Abstract
import com.example.holy_bible.data.net.BookServerModel
import com.example.holy_bible.domain.BookDomain
import java.lang.Exception

sealed class BookData : Abstract.Object<BookDomain, BooksDataToDomainMapper>(){
    class Success(private val books: List<BookServerModel>) : BookData() {
        override fun map(mapper: BooksDataToDomainMapper) = mapper.map(books)

    }

    class Fail(private val e:Exception) : BookData(){
        override fun map(mapper: BooksDataToDomainMapper) = mapper.map(e)

    }



//    class Success(private val books: List<BookServerModel>) : BookData{}
}