package com.example.mytest

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest{

    private lateinit var scenario: ActivityScenario<MainActivity>

    // the Rule calls before each of fun and this below Rule launch the activity
//    @get:Rule
//    val activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp(){
        scenario = ActivityScenario.launch(MainActivity::class.java)
       // scenario.moveToState(Lifecycle.State.RESUMED)
    }

    @Test
    fun testTextView_MainActivity(){
        onView(withId(R.id.txt_main)).perform(click())
       // onView(withId(R.id.my_fragment_root)).check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
        onView(withId(R.id.my_fragment_root)).check(matches(isDisplayed()))
    }

}