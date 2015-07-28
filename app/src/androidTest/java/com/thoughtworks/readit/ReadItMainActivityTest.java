package com.thoughtworks.readit;

import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.view.View;
import android.widget.ImageButton;

import junit.framework.Assert;



public class ReadItMainActivityTest extends ActivityInstrumentationTestCase2<ReadItMainActivity> {

    private ImageButton addResourceButton;

    public ReadItMainActivityTest() {
        super(ReadItMainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        ReadItMainActivity activity = getActivity();

        addResourceButton = (ImageButton)activity.findViewById(R.id.addResourceButton);

    }

    public void testonStartLayoutShoulsHaveButton() {

        Assert.assertNotNull(addResourceButton);

    }
}