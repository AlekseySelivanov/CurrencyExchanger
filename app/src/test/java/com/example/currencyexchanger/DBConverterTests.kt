package com.example.currencyexchanger

import com.example.currencyexchanger.model.db.DBConverter
import com.example.currencyexchanger.model.pojo.Currency
import org.junit.Assert.*
import org.junit.Test

class DBConverterTests {

    private val dbConverter = DBConverter

    private val sampleData = linkedMapOf(
        "Dollar" to Currency(charCode = "us", nominal = 1, name = "Dollar", value = 1.1),
        "Euro" to Currency(charCode = "eu", nominal = 2, name = "Euro", value = 2.2),
        "Rubble" to Currency(charCode = "ru", nominal = 3, name = "Rubble", value = 3.3)
    )

    private val sampleIncorrectString =
        """{"Dollar":{"CharCode":"us","Nominal":1,"Name":"Dollar","Value":1.1},"Euro":{"Nominal":2,"Name":"Euro","Value":2.2},"Rubble":{"CharCode":0,"Nominal":3,"Name":"Rubble","Value":3.3}}"""

    @Test
    fun `проверяем, что при корректных входных параметрах, fromMap вернет не пустую строку`() {
        val stringResult = dbConverter.fromMap(data = sampleData)
        assertTrue(stringResult.isNotEmpty())
    }

    @Test
    fun `проверяем, что результат fromMap может быть преобразован функцией toMap`() {
        val stringResult = dbConverter.fromMap(data = sampleData)
        assertEquals(sampleData, dbConverter.toMap(data = stringResult))
        println(stringResult)
    }

    @Test
    fun `проверяем, что при входящей пустой строке toMap выбрасывает NullPointerException`() {
        assertThrows(NullPointerException::class.java) {
            dbConverter.toMap("")
        }
    }

    @Test
    fun `проверяем, что при некорректном параметрах во входной строке, не выбрасывается никаких исключений`() {
        dbConverter.toMap(sampleIncorrectString)
    }

}