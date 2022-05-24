package com.example.currencyexchanger.kaspesso

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.currencyexchanger.kaspesso.screen.ConverterScreen
import com.example.currencyexchanger.kaspesso.tools.TestCase
import com.example.currencyexchanger.view.MainActivity
import com.example.currencyexchanger.view.converter.ConverterFragment
import org.junit.Rule
import org.junit.runner.RunWith
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class ConverterTest : KTestCase() {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    @TestCase(name = "Case 2", description = "2nd screen")
    fun checkConverter(){
        before{
            val scenario = launchFragmentInContainer<ConverterFragment>(initialState = Lifecycle.State.INITIALIZED)
            scenario.moveToState(Lifecycle.State.RESUMED)
        }.after {  }.
            run{
            step("checkConverter"){
                ConverterScreen{
                    numToConvert{
                    isDisplayed()
                    typeText("1000")
                    }
                    numConverted{
                    isDisplayed()
                    }
                }
            }
        }
    }
}