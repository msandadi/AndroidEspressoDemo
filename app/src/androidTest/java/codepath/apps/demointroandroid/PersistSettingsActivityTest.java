package codepath.apps.demointroandroid;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.test.filters.LargeTest;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class PersistSettingsActivityTest {

    @Rule
    public ActivityTestRule<PersistSettingsActivity> mActivityRule = new ActivityTestRule<>(
            PersistSettingsActivity.class,
            true,
            true);

    @Test
    public void verifyTextIsPersisted(){
        onView(withId(R.id.txtPersistText)).perform(clearText(),typeText("Some Text"));
        onView(withId(R.id.btnPersistValues)).perform(closeSoftKeyboard(),click());
        mActivityRule.launchActivity(new Intent());
        onView(withId(R.id.txtPersistText)).check(matches(withText("Some Text")));
    }

    @Test
    public void verifyEmptyText(){
        onView(withId(R.id.txtPersistText)).perform(clearText(),typeText(""));
        onView(withId(R.id.btnPersistValues)).perform(closeSoftKeyboard(),click());
        mActivityRule.launchActivity(new Intent());
        onView(withId(R.id.txtPersistText)).check(matches(withText("")));
    }

    @Test
    public void verifyLastSaved(){
        onView(withId(R.id.txtPersistText)).perform(clearText(),typeText("Some Text"));
        onView(withId(R.id.btnPersistValues)).perform(closeSoftKeyboard(),click());
        onView(withId(R.id.txtPersistText)).perform(clearText(),typeText("Some Text1"));
        onView(withId(R.id.btnPersistValues)).perform(closeSoftKeyboard(),click());
        onView(withId(R.id.txtPersistText)).perform(clearText(),typeText("Some Text2"));
        onView(withId(R.id.btnPersistValues)).perform(closeSoftKeyboard(),click());
        mActivityRule.launchActivity(new Intent());
        onView(withId(R.id.txtPersistText)).check(matches(withText("Some Text2")));
    }



}