package com.example.holy_bible.data.cache

import com.example.holy_bible.core.Abstract
import com.example.holy_bible.core.Book
import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class BookDb : RealmObject(), Abstract.Mapable<Book, BookCacheMapper>{
    @PrimaryKey
    var id: Int = -1
    var name : String = ""


    override fun map(mapper: BookCacheMapper) = Book(id, name)

}
