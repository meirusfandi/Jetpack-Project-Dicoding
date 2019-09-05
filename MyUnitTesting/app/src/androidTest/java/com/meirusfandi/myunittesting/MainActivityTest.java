package com.meirusfandi.myunittesting;

import androidx.test.espresso.ViewAction;
import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.hasErrorText;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    private String dummyVolume = "504.0";
    private String dummyCircum = "2016.0";
    private String dummySurface = "396.0";
    private String dummyLength = "12.0";
    private String dummyHeight = "6.0";
    private String dummyWidth = "7.0";
    private String emptyInput = "";
    private String fieldEmpty = "Field cannot empty!";

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void getCircumference() {
        onView(withId(R.id.edit_length)).perform(typeText(dummyLength), closeSoftKeyboard());
        onView(withId(R.id.edit_width)).perform(typeText(dummyWidth), closeSoftKeyboard());
        onView(withId(R.id.edit_height)).perform(typeText(dummyHeight), closeSoftKeyboard());
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());
        onView(withId(R.id.calculate_circumference)).check(matches(isDisplayed()));
        onView(withId(R.id.calculate_circumference)).perform(click());
        onView(withId(R.id.tv_result)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_result)).check(matches(withText(dummyCircum)));
    }

    @Test
    public void getVolume() {
        onView(withId(R.id.edit_length)).perform(typeText(dummyLength), closeSoftKeyboard());
        onView(withId(R.id.edit_width)).perform(typeText(dummyWidth), closeSoftKeyboard());
        onView(withId(R.id.edit_height)).perform(typeText(dummyHeight), closeSoftKeyboard());
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());
        onView(withId(R.id.calculate_volume)).check(matches(isDisplayed()));
        onView(withId(R.id.calculate_volume)).perform(click());
        onView(withId(R.id.tv_result)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_result)).check(matches(withText(dummyVolume)));
    }

    @Test
    public void getSurface() {
        onView(withId(R.id.edit_length)).perform(typeText(dummyLength), closeSoftKeyboard());
        onView(withId(R.id.edit_width)).perform(typeText(dummyWidth), closeSoftKeyboard());
        onView(withId(R.id.edit_height)).perform(typeText(dummyHeight), closeSoftKeyboard());
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());
        onView(withId(R.id.calculate_surface_area)).check(matches(isDisplayed()));
        onView(withId(R.id.calculate_surface_area)).perform(click());
        onView(withId(R.id.tv_result)).check(matches(isDisplayed()));
        onView(withId(R.id.tv_result)).check(matches(withText(dummySurface)));
    }

    @Test
    public void emptyInput() {
        onView(withId(R.id.edit_length)).perform(typeText(emptyInput), closeSoftKeyboard());
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());
        onView(withId(R.id.edit_length)).check(matches(hasErrorText(fieldEmpty)));
        onView(withId(R.id.edit_length)).perform(typeText(dummyLength), closeSoftKeyboard());
        onView(withId(R.id.edit_width)).perform(typeText(emptyInput), closeSoftKeyboard());
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());
        onView(withId(R.id.edit_width)).check(matches(hasErrorText(fieldEmpty)));
        onView(withId(R.id.edit_width)).perform(typeText(dummyWidth), closeSoftKeyboard());
        onView(withId(R.id.edit_height)).perform(typeText(emptyInput), closeSoftKeyboard());
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());
        onView(withId(R.id.edit_height)).check(matches(hasErrorText(fieldEmpty)));
        onView(withId(R.id.edit_height)).perform(typeText(dummyHeight), closeSoftKeyboard());
        onView(withId(R.id.btn_save)).check(matches(isDisplayed()));
        onView(withId(R.id.btn_save)).perform(click());
    }
}