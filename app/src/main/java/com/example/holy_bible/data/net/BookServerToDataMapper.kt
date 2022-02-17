package com.example.holy_bible.data.net

import com.example.holy_bible.core.Abstract
import com.example.holy_bible.data.BookData

interface BookServerToDataMapper : Abstract.Mapper{
    fun map(id: Int, name: String) : BookData
}
