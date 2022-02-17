package com.example.holy_bible.domain

import com.example.holy_bible.core.Abstract
import com.example.holy_bible.data.net.BookServerModel
import com.example.holy_bible.presentation.BookUI

sealed class BookDomain : Abstract.Object<BookUI, Abstract.Mapper.Empty>() {
    class Success(): BookDomain() {
        override fun map(mapper: Abstract.Mapper.Empty): BookUI {
            TODO("Not yet implemented")
        }
    }

    class Fail(private val errorType: Int) : BookDomain() {
        override fun map(mapper: Abstract.Mapper.Empty): BookUI {
            TODO("Not yet implemented")
        }
    }
}