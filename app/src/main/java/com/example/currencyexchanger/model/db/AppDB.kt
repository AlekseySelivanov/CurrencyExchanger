package com.example.currencyexchanger.model.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.currencyexchanger.model.pojo.CurrencyInfo

@Database(entities = [CurrencyInfo::class], version = 2)
@TypeConverters(DBConverter::class)
abstract class AppDB: RoomDatabase() {
    abstract fun appDao(): AppDao
}