package codepath.apps.demointroandroid;

import android.view.View;
import android.widget.TimePicker;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isAssignableFrom;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static 	androidx.test.espresso.contrib.PickerActions.setTime;

import java.util.Calendar;

import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class TimePickerDemoActivityTest {

    @Rule
    public ActivityTestRule<TimePickerDemoActivity> mActivityTestRule
            = new ActivityTestRule<>(TimePickerDemoActivity.class);


    @Test
    public void verifySetTimeInTimePicker() {
        onView(isAssignableFrom(TimePicker.class)).perform(setTime(14, 36));
        onView(withId(R.id.btnDisplayTime)).perform(click());
        onView(withText("14:36")).inRoot(withDecorView(not(is(mActivityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    @Test
    public void verifyGreaterThan24Hours(){
        onView(isAssignableFrom(TimePicker.class)).perform(setTime(25, 40));
        onView(withId(R.id.btnDisplayTime)).perform(click());
        onView(withText("23:40")).inRoot(withDecorView(not(is(mActivityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

}