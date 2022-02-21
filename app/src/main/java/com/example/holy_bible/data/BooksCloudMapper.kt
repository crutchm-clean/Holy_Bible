package com.example.holy_bible.data

import com.example.holy_bible.core.Abstract
import com.example.holy_bible.core.Book
import com.example.holy_bible.data.net.BookCloud
import com.example.holy_bible.data.net.BookCloudMapper

interface BooksCloudMapper : Abstract.Mapper {

    fun map(cloudList: List<BookCloud>) : List<Book>


    class Base (private val bookMapper: BookCloudMapper): BooksCloudMapper{
        override fun map(cloudList: List<BookCloud>) = cloudList.map{ bookCloud -> bookCloud.map(bookMapper) }
    }
}