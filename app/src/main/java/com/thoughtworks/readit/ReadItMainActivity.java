package com.thoughtworks.readit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.thoughtworks.readit.activity.AddResourceActivity;
import com.thoughtworks.readit.adapter.ResourceAdapter;
import com.thoughtworks.readit.domain.Resource;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ReadItMainActivity extends Activity {

    private ImageButton addResourceButton;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

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

        mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);

        List<Resource> resources =  getResourcesList();
        // specify an adapter (see also next example)
        mAdapter = new ResourceAdapter(resources);
        mRecyclerView.setAdapter(mAdapter);
    }

    private List<Resource> getResourcesList() {
        String url = "http://readit.thoughtworks.com/resources";
        final List<Resource> resources = new ArrayList<>();

        JsonArrayRequest jsonReq = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject res = (JSONObject) response.get(i);
                        String link = res.getString("link");
                        String title = res.getString("title");
                        Resource r = new Resource();
                        r.setLink(link);
                        r.setTitle(title);
                        resources.add(r);
                    }

                    mAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                volleyError.getCause();
            }
        });

        ApplicationController.getInstance().addToRequestQueue(jsonReq);

        return resources;
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}