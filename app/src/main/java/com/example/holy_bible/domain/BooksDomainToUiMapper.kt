package com.example.holy_bible.domain

import com.example.holy_bible.core.Abstract
import com.example.holy_bible.core.Book
import com.example.holy_bible.presentation.BooksUI

interface BooksDomainToUiMapper : Abstract.Mapper {

    fun map(books: List<Book>) : BooksUI

    fun map(errorType: ErrorType) : BooksUI
}