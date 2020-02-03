package com.example.nikeassessment.ui

import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.nikeassessment.R
import com.example.nikeassessment.util.EspressoUtil
import com.example.nikeassessment.util.RecyclerViewItemAssertion
import com.example.nikeassessment.util.SearchViewActionUtil
import org.junit.FixMethodOrder
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.MethodSorters

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(AndroidJUnit4ClassRunner::class)
class MainFragmentTest {

    @get:Rule
    val activityRule = ActivityScenarioRule(MainActivity::class.java)
    // private val testDispatcher = TestCoroutineDispatcher()

    @Test
    fun whenSearchQueryIsClickedApiCallShouldHappen() {

        Espresso.onView(withId(R.id.searchView)).perform(SearchViewActionUtil.submitText("wap"))
        Espresso.onView(isRoot()).perform(EspressoUtil.waitFor(5000))
        Espresso.onView(withId(R.id.recyclerView)).check(ViewAssertions.matches(isDisplayed()))

    }

    @Test
    fun when_search_query_is_clicked_api_call_should_happen_and_certain_results_should_display() {
        Espresso.onView(withId(R.id.searchView)).perform(SearchViewActionUtil.submitText("w"))
        Espresso.onView(isRoot()).perform(EspressoUtil.waitFor(5000))
        Espresso.onView(withId(R.id.recyclerView)).check(RecyclerViewItemAssertion(10))
    }


}