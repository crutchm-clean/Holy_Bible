package com.example.holy_bible.data

import com.example.holy_bible.core.Abstract
import com.example.holy_bible.domain.BookDomain

sealed class BookData : Abstract.Object<BookDomain, Abstract.Mapper.Empty>(){
}