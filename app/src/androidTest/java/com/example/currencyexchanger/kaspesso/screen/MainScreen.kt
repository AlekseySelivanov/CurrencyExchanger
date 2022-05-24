package com.example.currencyexchanger.kaspesso.screen

import android.view.View
import com.agoda.kakao.bottomnav.KBottomNavigationView
import com.agoda.kakao.recycler.KRecyclerItem
import com.agoda.kakao.recycler.KRecyclerView
import com.agoda.kakao.screen.Screen
import com.agoda.kakao.text.KButton
import com.agoda.kakao.text.KTextView
import com.example.currencyexchanger.R
import org.hamcrest.Matcher

object MainScreen : Screen<MainScreen>() {
    val tabLayout = KBottomNavigationView {withId(R.id.tab_layout)}
    val refreshBtn = KButton{withId(R.id.refresh_btn)}
    val headTitle = KTextView{withId(R.id.head)}


    val currencyList = KRecyclerView(
        builder = { withId(R.id.recycler_view) },
        itemTypeBuilder = { itemType(::TransactionItem) }
    )

    class TransactionItem(parent: Matcher<View>) : KRecyclerItem<TransactionItem>(parent) {

        val code = KTextView(parent) { withId(R.id.char_code) }
        val name = KTextView(parent) { withId(R.id.name) }
    }

}