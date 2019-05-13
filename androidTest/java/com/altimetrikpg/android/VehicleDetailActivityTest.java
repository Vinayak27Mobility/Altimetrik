package com.altimetrikpg.android;

import android.support.test.runner.AndroidJUnit4;

import com.altimetrikpg.android.view.impl.VehicleDetailActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.containsString;


@RunWith(AndroidJUnit4.class)
public class VehicleDetailActivityTest {
    @Rule public final ActivityRule<VehicleDetailActivity> mainActivity = new ActivityRule<>(VehicleDetailActivity.class);

    @Test
    public void launchMainScreen() {
        //onView(withText(containsString("ACTIVE"))).check(matches(isDisplayed()));
        onView(withText(containsString(mainActivity.get().getString(R.string.vehicle_detail_title)))).check(matches(isDisplayed()));
    }

}
