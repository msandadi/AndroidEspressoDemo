package codepath.apps.demointroandroid;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ProgressBarActivityTest {
    @Rule
    public ActivityTestRule<ProgressBarActivity> mActivityTestRule
            = new ActivityTestRule<>(ProgressBarActivity.class);

    @Test
    public void checkWithTheTextChanges(){
        onView(withId(R.id.button1)).perform(click());
        onView(allOf(withId(R.id.txtUrlOutput), not(withText("Responses Live Here"))));
        onView(withText("Completed!")).inRoot(withDecorView(not(is(mActivityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }
}