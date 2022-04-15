package com.example.currencyexchanger.model.network

import com.example.currencyexchanger.model.pojo.CurrencyInfo
import retrofit2.http.GET

interface NetworkAPI {
    @GET("/daily_json.js")
    suspend fun getActualValuteInfo(): CurrencyInfo
}