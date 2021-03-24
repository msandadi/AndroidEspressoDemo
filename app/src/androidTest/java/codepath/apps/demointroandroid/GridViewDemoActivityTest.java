package codepath.apps.demointroandroid;

import androidx.test.rule.ActivityTestRule;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static codepath.apps.demointroandroid.EspressoTestMatchers.withDrawable;
import static org.hamcrest.Matchers.anything;
import static org.hamcrest.Matchers.containsString;
import static org.junit.Assert.*;
@RunWith(AndroidJUnit4.class)
public class GridViewDemoActivityTest {
    @Rule
    public ActivityTestRule<GridViewDemoActivity> mActivityTestRule
            = new ActivityTestRule<>(GridViewDemoActivity.class);

   private static int[] drawableIds = new int[]{R.drawable.ad,R.drawable.ae,R.drawable.af,R.drawable.ag,R.drawable.ai,R.drawable.al};

    @Test
    public void checkGridViewHasImagesFromDrawable() {
        for(int i = 0; i < drawableIds.length;i++) {
            onData(anything()).inAdapterView(withId(R.id.gvImages)).atPosition(i).
                    check(matches(withDrawable(drawableIds[i])));
        }
    }
}