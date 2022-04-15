package com.example.currencyexchanger.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.currencyexchanger.model.pojo.CurrencyInfo

@Dao
interface AppDao {
    @Query("SELECT * FROM CurrencyInfo")
    fun getValuteInfo(): CurrencyInfo?

    @Insert
    fun insert(currencyInfo: CurrencyInfo)

    @Update
    fun update(currencyInfo: CurrencyInfo)

    @Query("DELETE FROM CurrencyInfo")
    fun delete()
}
