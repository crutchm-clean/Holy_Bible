package com.example.holy_bible.domain

import com.example.holy_bible.core.Abstract
import com.example.holy_bible.core.Book
import com.example.holy_bible.presentation.BooksUI
import retrofit2.HttpException
import retrofit2.http.HTTP
import java.lang.Exception
import java.net.UnknownHostException

sealed class BooksDomain : Abstract.Object<BooksUI, BooksDomainToUiMapper>() {

    class Success(private val books: List<Book>) : BooksDomain() {
        override fun map(mapper: BooksDomainToUiMapper) = mapper.map(books)
    }

    class Fail(private val e: Exception) : BooksDomain() {
        override fun map(mapper: BooksDomainToUiMapper) = mapper.map(when(e){
                 is UnknownHostException -> ErrorType.NO_CONNECTION
                 is HttpException -> ErrorType.SERVICE_UNAVAILABLE
                 else -> ErrorType.GENERIC_ERROR
            })

    }
}


