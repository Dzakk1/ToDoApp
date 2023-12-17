package com.dicoding.todoapp.ui.list

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.dicoding.todoapp.R
import org.junit.Test

//TODO 16 : Write UI test to validate when user tap Add Task (+), the AddTaskActivity displayed
class TaskActivityTest {

    @Test
    fun uiTestValidate(){
        ActivityScenario.launch(TaskActivity::class.java)
        Espresso.onView(ViewMatchers.withId(R.id.fab)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.add_ed_title))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.add_ed_description))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.add_tv_due_date))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}