package com.example.holy_bible.data.net

import com.example.holy_bible.core.Abstract
import com.example.holy_bible.data.BookData
import com.google.gson.annotations.SerializedName

data class BookServerModel(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("name")
    private val name: String) : Abstract.Object<BookData, BookServerToDataMapper>() {

    override fun map(mapper: BookServerToDataMapper) = mapper.map(id, name)



}
