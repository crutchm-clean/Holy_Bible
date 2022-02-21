package com.example.holy_bible.domain

import com.example.holy_bible.data.BooksDataToDomainMapper
import com.example.holy_bible.data.BooksRepository
import com.example.holy_bible.presentation.BooksUI

interface BooksInteractor {

   suspend fun fetchBooks() : BooksDomain

    class Base(private val booksRepository: BooksRepository,
               private val mapper: BooksDataToDomainMapper) : BooksInteractor {
        override suspend fun fetchBooks() = booksRepository.fetchBooks().map(mapper)

    }
}