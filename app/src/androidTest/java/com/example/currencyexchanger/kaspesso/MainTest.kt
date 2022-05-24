package com.example.currencyexchanger.kaspesso

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.currencyexchanger.R
import com.example.currencyexchanger.kaspesso.screen.MainScreen
import com.example.currencyexchanger.kaspesso.tools.TestCase
import com.example.currencyexchanger.view.MainActivity
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class MainTest : KTestCase() {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    @TestCase(name = "Case 1", description = "1st screen")
    fun checkMainActivity(){
        run {
            step("checkView"){
                MainScreen{
                    tabLayout{
                    isCompletelyDisplayed()
                    }
                    refreshBtn{
                    isVisible()
                    hasText(R.string.refresh)
                    }
                    headTitle{
                    isVisible()
                    hasText(R.string.head_title)
                    }
                }
            }
            step("check_rv"){
                check_rv(
                    Transaction(code = "AUD", name = "Австралийский доллар" )
                )
            }
        }
    }

    data class Transaction(val code: String, val name: String)

    private fun check_rv(vararg correctName: Transaction){
        correctName.forEachIndexed { index, transaction ->
            MainScreen{
                currencyList{
                    childAt<MainScreen.TransactionItem>(index){
                        code{
                            isDisplayed()
                            hasText(transaction.code)
                        }
                        name{
                            isDisplayed()
                            hasText(transaction.name)
                        }
                    }
                }
            }
        }
    }



}