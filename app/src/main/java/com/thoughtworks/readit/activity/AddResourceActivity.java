package com.thoughtworks.readit.activity;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.thoughtworks.readit.ApplicationController;
import com.thoughtworks.readit.R;
import com.thoughtworks.readit.ReadItMainActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

public class AddResourceActivity extends Activity {

    private Button shareButton;
    private final String TAG = "Request_Resource";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_resource);

        shareButton =  (Button)findViewById(R.id.shareButton);

        shareButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String tag_json_obj = "json_obj_req";
                String url = "http://readit.thoughtworks.com/resources";

                final ProgressDialog pDialog = new ProgressDialog(AddResourceActivity.this);
                pDialog.setMessage("Sharing ...");
                pDialog.show();


                final JSONObject jsonObject = new JSONObject();

                try {
                    jsonObject.put("link", "google.com");

                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.e("Authentication", "User authentication is failed" + e.getMessage());
                }

                JsonObjectRequest jsonObjReq = new JsonObjectRequest(Request.Method.POST,
                        url, jsonObject,
                        new Response.Listener<JSONObject>(){

                            @Override
                            public void onResponse(JSONObject response) {
                                Log.d(TAG, response.toString());
                                pDialog.hide();

                                Intent addResourceIntent = new Intent(AddResourceActivity.this, ReadItMainActivity.class);
                                startActivity(addResourceIntent);
                            }
                        }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        VolleyLog.d(TAG, "Error: " + error.getMessage());
                        Toast.makeText(AddResourceActivity.this, "Problem occurred, try again later!", Toast.LENGTH_LONG);
                        // hide the progress dialog
                        pDialog.hide();
                    }
                });

                // Adding request to request queue
                ApplicationController.getInstance().addToRequestQueue(jsonObjReq, tag_json_obj);

            }
        });
    }
}
