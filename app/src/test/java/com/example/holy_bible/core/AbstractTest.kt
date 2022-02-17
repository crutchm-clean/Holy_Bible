package com.example.holy_bible.core

import junit.framework.Assert.assertTrue
import org.junit.Test
import java.lang.Exception

class AbstractTest{

    @Test
    fun test_success(){
        val dataObject = TestDataObject.Success("a", "b")
        val domainObject = dataObject.map(DataMapper.Base())
        assertTrue(domainObject is DomainObject.Success)
    }

    private sealed class TestDataObject : Abstract.Object<DomainObject, DataToDomainMapper>() {
        abstract override fun map(mapper: DataToDomainMapper): DomainObject

        class Success(private val textOne : String, private val textTwo : String): TestDataObject(){
            override fun map(mapper: DataToDomainMapper): DomainObject {
                return mapper.map(textOne, textTwo)
            }
        }

        class Fail(private val exception: Exception) : TestDataObject(){
            override fun map(mapper: DataToDomainMapper): DomainObject {
                return mapper.map(exception)
            }
        }

    }

    private interface DataToDomainMapper : Abstract.Mapper{
        fun map(textOne: String, textTwo: String) : DomainObject
        fun map(exception: Exception) : DomainObject
    }

    private sealed class DomainObject : Abstract.Object<UiObject, DataMapper>(){

        class Success(private val textCombined : String) : DomainObject() {
            override fun map(mapper: DataMapper): UiObject {
                TODO("Not yet implemented")
            }
        }

        class Fail : DomainObject(){
            override fun map(mapper: DataMapper): UiObject {
                TODO("Not yet implemented")
            }
        }
    }


    private sealed class UiObject

    private interface DataMapper: Abstract.Mapper{
        fun map(textOne: String, textTwo: String) : DomainObject

        fun map(exception: Exception) : DomainObject

        class Base: DataToDomainMapper{

            override fun map(textOne: String, textTwo: String): DomainObject {
                return DomainObject.Success(textOne+textTwo)
            }

            override fun map(exception: Exception): DomainObject {
                return DomainObject.Fail()
            }
        }
    }

}