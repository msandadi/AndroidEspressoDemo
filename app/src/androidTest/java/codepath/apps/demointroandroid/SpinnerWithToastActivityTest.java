package codepath.apps.demointroandroid;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.Arrays;
import java.util.List;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class SpinnerWithToastActivityTest {
    @Rule
    public ActivityTestRule<SpinnerWithToastActivity> mActivityTestRule
            = new ActivityTestRule<>(SpinnerWithToastActivity.class);

    private static final List<String> colors = Arrays.asList("Red", "Orange", "Yellow", "Green", "Blue", "Indigo", "Violet");

    @Test
    public void verifySelectedSpinnerOptionsTest() throws InterruptedException {
        for(String color: colors) {
            onView(withId(R.id.spnOptions)).perform(click());
            onData(allOf(is(instanceOf(String.class)), is(color))).perform(closeSoftKeyboard(),click());
            onView(withId(R.id.btnSpinnerValue)).perform(closeSoftKeyboard(), click());
            onView(withText(color)).inRoot(withDecorView(not(is(mActivityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
            //Thread.sleep is not recommended. Just writing for this assignment purpose
            Thread.sleep(1000);
        }
    }
}