package com.thoughtworks.readit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.thoughtworks.readit.activity.AddResourceActivity;

public class ReadItMainActivity extends Activity {

    private ImageButton addResourceButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addResourceButton =  (ImageButton)findViewById(R.id.addResourceButton);

        addResourceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addResourceIntent = new Intent(ReadItMainActivity.this, AddResourceActivity.class);
                startActivity(addResourceIntent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}