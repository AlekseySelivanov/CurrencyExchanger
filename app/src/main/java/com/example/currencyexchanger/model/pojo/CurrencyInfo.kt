package com.example.currencyexchanger.model.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class CurrencyInfo (
    @PrimaryKey(autoGenerate = true)
    var id: Int,
    @SerializedName("Date")
    var date: String,
    @SerializedName("Valute")
    var valutes: LinkedHashMap<String, Currency>
) {
    override fun equals(other: Any?): Boolean {
        if (other is CurrencyInfo) {
            return date == other.date && valutes == other.valutes
        }
        return false
    }

    fun getCopy(): CurrencyInfo {
        return CurrencyInfo(id, date, valutes.clone() as LinkedHashMap<String, Currency>)
    }
}