package com.example.holy_bible.data.cache

import com.example.holy_bible.core.Book

interface BooksCacheDataSource  {

    fun fetchBooks() : List<BookDb>

    fun saveBooks(books: List<Book>)

    class Base(private val realmProvider: RealmProvider): BooksCacheDataSource {
        override fun fetchBooks() = realmProvider.provide().use {
            realm -> realm.copyFromRealm(realm.where(BookDb::class.java).findAll())
        }

        override fun saveBooks(books: List<Book>) = realmProvider.provide().use {
                realm -> realm.executeTransaction{
                    books.forEach {book ->
                        val bookDb = it.createObject(BookDb::class.java, book.id)

                        bookDb.name = book.name
                    }
                }
            }

    }
}