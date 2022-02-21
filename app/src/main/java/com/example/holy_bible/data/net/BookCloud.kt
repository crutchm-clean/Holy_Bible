package com.example.holy_bible.data.net

import com.example.holy_bible.core.Abstract
import com.example.holy_bible.core.Book
import com.google.gson.annotations.SerializedName

data class BookCloud(
    @SerializedName("id")
    private val id: Int,
    @SerializedName("name")
    private val name: String) : Abstract.Object<Book, BookCloudMapper>() {

    override fun map(mapper: BookCloudMapper) =  mapper.map(id, name)



}
