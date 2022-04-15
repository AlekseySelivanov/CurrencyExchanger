package com.example.currencyexchanger.model.db

import androidx.room.TypeConverter
import com.example.currencyexchanger.model.pojo.Currency
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class DBConverter {

    companion object {

        @TypeConverter @JvmStatic
        fun fromMap(data: LinkedHashMap<String, Currency>): String {
            val gson = Gson()
            return gson.toJson(data)
        }

        @TypeConverter @JvmStatic
        fun toMap(data: String): LinkedHashMap<String, Currency> {
            val gson = Gson()
            return gson.fromJson(data, object : TypeToken<LinkedHashMap<String, Currency>>() {}.type)
        }
    }
}