package com.thoughtworks.readit;

import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityUnitTestCase;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.thoughtworks.readit.activity.AddResourceActivity;

import junit.framework.Assert;



public class AddResourceActivityTest extends ActivityInstrumentationTestCase2<AddResourceActivity> {

    private Button shareButton;
    private EditText resourceLink;

    public AddResourceActivityTest() {
        super(AddResourceActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        AddResourceActivity activity = getActivity();

        shareButton = (Button)activity.findViewById(R.id.shareButton);
        resourceLink =  (EditText)activity.findViewById(R.id.resourceLink);

    }

    public void testonStartLayoutShoulsHavePrepared() {

        Assert.assertNotNull(shareButton);
        Assert.assertNotNull(resourceLink);

    }
}