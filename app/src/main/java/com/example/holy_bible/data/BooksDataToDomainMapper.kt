package com.example.holy_bible.data

import com.example.holy_bible.core.Abstract
import com.example.holy_bible.core.Book
import com.example.holy_bible.data.net.BookCloud
import com.example.holy_bible.domain.BookDomain
import retrofit2.HttpException
import java.net.UnknownHostException

interface BooksDataToDomainMapper : Abstract.Mapper{
    fun map(books: List<Book>): BookDomain

    fun map(e: Exception): BookDomain


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
