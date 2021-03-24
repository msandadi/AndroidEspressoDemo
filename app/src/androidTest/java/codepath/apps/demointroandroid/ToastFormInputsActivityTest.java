package codepath.apps.demointroandroid;



import androidx.test.runner.AndroidJUnit4;


import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

@RunWith(AndroidJUnit4.class)
public class ToastFormInputsActivityTest {
    @Rule public ActivityTestRule<ToastFormInputsActivity> mActivityTestRule
            = new ActivityTestRule<>(ToastFormInputsActivity.class);

    @Test
    public void verifyCheckBoxIsNotSelected_SecondRadioButtonSelected(){
        onView(withId(R.id.etVal)).perform(clearText(),typeText("Some Text"));
        onView(withId(R.id.rbOne)).perform(click());
        onView(withId(R.id.button1)).perform(closeSoftKeyboard(),click());
        onView(withText("Some Text | false | First")).inRoot(withDecorView(not(is(mActivityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }

    @Test
    public void verifyCheckBoxIsSelected_SecondRadioButtonSelected(){
        verifyCheckBoxAndRadioButton(R.id.rbTwo,"Some Text | true | Second");
    }

    @Test
    public void verifyCheckBoxIsSelected_ThirdRadioButtonSelected(){
        verifyCheckBoxAndRadioButton(R.id.rbThree,"Some Text | true | Three");
    }

    private void verifyCheckBoxAndRadioButton(int radioButtonId,String text){
        onView(withId(R.id.etVal)).perform(clearText(),typeText("Some Text"));
        onView(withId(R.id.chkVal)).perform(click());
        onView(withId(radioButtonId)).perform(closeSoftKeyboard(),click());
        onView(withId(R.id.button1)).perform(closeSoftKeyboard(),click());
        onView(withText(text)).inRoot(withDecorView(not(is(mActivityTestRule.getActivity().getWindow().getDecorView())))).check(matches(isDisplayed()));
    }


}