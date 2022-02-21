package com.example.holy_bible.data.net

import com.example.holy_bible.core.Abstract
import com.example.holy_bible.core.Book

interface BookCloudMapper : Abstract.Mapper{
    fun map(id: Int, name: String) : Book

    class Base : BookCloudMapper{
        override fun map(id: Int, name: String) = Book(id, name)
    }
}
