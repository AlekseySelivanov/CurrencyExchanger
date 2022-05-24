package com.example.currencyexchanger.kaspesso.screen

import com.agoda.kakao.edit.KEditText
import com.agoda.kakao.screen.Screen
import com.example.currencyexchanger.R

object ConverterScreen : Screen<ConverterScreen>() {

    val numToConvert = KEditText { withId(R.id.num_to_convert) }
    val numConverted = KEditText { withId(R.id.num_converted) }

}