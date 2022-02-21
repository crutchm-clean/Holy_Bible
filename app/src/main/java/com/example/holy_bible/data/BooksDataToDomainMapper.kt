package com.example.holy_bible.data

import com.example.holy_bible.core.Abstract
import com.example.holy_bible.core.Book
import com.example.holy_bible.domain.BooksDomain

interface BooksDataToDomainMapper : Abstract.Mapper{
    fun map(books: List<Book>): BooksDomain

    fun map(e: Exception): BooksDomain


//    class Base: BooksDataToDomainMapper{
//        override fun map(books: List<BookCloud>)= BookDomain.Success()
//
//
//        override fun map(e: Exception): BookDomain {
//            val errorType = when(e){
//                is UnknownHostException-> 0
//                is HttpException -> 1
//                else -> 2
//            }
//            return BookDomain.Fail(errorType)
//        }
//    }
}
