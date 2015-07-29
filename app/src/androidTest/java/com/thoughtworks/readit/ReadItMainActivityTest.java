package com.thoughtworks.readit;

import android.content.Intent;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.view.View;
import android.widget.ImageButton;

import com.thoughtworks.readit.ReadItMainActivity;

import junit.framework.Assert;



public class ReadItMainActivityTest extends ActivityUnitTestCase<ReadItMainActivity> {

    private ImageButton addResourceButton;

    public ReadItMainActivityTest() {
        super(ReadItMainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
        Intent launchIntent = new Intent(getInstrumentation().getTargetContext(), ReadItMainActivity.class);
        startActivity(launchIntent,null,null);
        ReadItMainActivity activity = getActivity();

        addResourceButton = (ImageButton)activity.findViewById(R.id.addResourceButton);

    }

    public void testonStartLayoutShouldHaveButton() {
        Assert.assertNotNull(addResourceButton);
    }

    public void testButtonOnClickShouldStartAddResourceActivity() {
        addResourceButton.performClick();
        final Intent passedIntent = getStartedActivityIntent();
        assertNotNull("Intent is not null",passedIntent);
    }

}