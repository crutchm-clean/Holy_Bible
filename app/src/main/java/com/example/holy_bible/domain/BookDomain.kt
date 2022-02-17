package com.example.holy_bible.domain

import com.example.holy_bible.core.Abstract
import com.example.holy_bible.presentation.BookUI

sealed class BookDomain : Abstract.Object<BookUI, Abstract.Mapper.Empty>() {
}