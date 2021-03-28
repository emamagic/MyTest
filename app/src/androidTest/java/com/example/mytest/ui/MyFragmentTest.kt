package com.example.mytest.ui

import androidx.fragment.app.testing.FragmentScenario
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.mytest.R
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class MyFragmentTest{

    private lateinit var scenario: FragmentScenario<MyFragment>

    @Before
    fun setUp(){
        scenario = launchFragmentInContainer(themeResId = R.style.Theme_MyTest)
      //  scenario.moveToState(Lifecycle.State.STARTED)
    }

    @Test
    fun testSubmitClicked(){
        onView(withId(R.id.edt_name)).perform(typeText("ali"))
        onView(withId(R.id.edt_family)).perform(typeText("aliii"))
        Espresso.closeSoftKeyboard()
        onView(withId(R.id.btn_submit)).perform(click())
        onView(withId(R.id.txt_result)).check(matches(withText("Successfully")))
    }


}