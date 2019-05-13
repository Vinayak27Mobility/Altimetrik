package com.altimetrikpg.android;

import android.support.test.runner.AndroidJUnit4;

import com.altimetrikpg.android.view.impl.VehicleIdActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.pressImeActionButton;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;


@RunWith(AndroidJUnit4.class)
public class VehicleIdActivityTest {
    @Rule public final ActivityRule<VehicleIdActivity> mainActivity = new ActivityRule<>(VehicleIdActivity.class);

    @Test
    public void launchMainScreen() {
        onView(withText(containsString(mainActivity.get().getString(R.string.vehicle_id_title)))).check(matches(isDisplayed()));
    }

    @Test
    public void launchDetailScreen() {
        onView(withId(R.id.vehicle_id_et))
                .perform(typeText(""), pressImeActionButton());
    }
}
