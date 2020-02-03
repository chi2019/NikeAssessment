package com.example.nikeassessment.util

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.matcher.ViewMatchers.isRoot
import org.hamcrest.Matcher


class EspressoUtil {

    companion object {
        fun waitFor(millis: Long): ViewAction {
            return object : ViewAction {
                override fun getDescription(): String {
                    return "Wait for $millis milliseconds."
                }

                override fun getConstraints(): Matcher<View> {
                    return isRoot()
                }

                override fun perform(uiController: UiController?, view: View?) {
                    uiController?.loopMainThreadForAtLeast(millis)
                }

            }
        }
    }

}