package com.example.rishab.medivision;

import android.content.Intent;

import android.graphics.Bitmap;

import android.os.AsyncTask;

import android.provider.MediaStore;

import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;

import android.util.Base64;

import android.util.Log;

import android.view.View;

import android.widget.EditText;

import android.widget.Spinner;

import android.widget.Toast;


import org.json.JSONException;

import org.json.JSONObject;


import java.io.IOException;

import okhttp3.MediaType;

import okhttp3.OkHttpClient;

import okhttp3.Request;

import okhttp3.RequestBody;

import okhttp3.Response;


import static android.R.attr.name;

public class Registeration extends AppCompatActivity {

    public String url_worker_register ="https://hint2017-3f06.restdb.io/rest/patient-data?apikey=e66029608a8120c06509e329d27d385d8a528";

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");


    public void register(View view){

        String aadhar= ((EditText)findViewById(R.id.aadhar)).getText().toString();

        String first_name = ((EditText)findViewById(R.id.first_name)).getText().toString();

        String middle_name = ((EditText)findViewById(R.id.middle_name)).getText().toString();

        String last_name = ((EditText)findViewById(R.id.last_name)).getText().toString();

        String dob= ((EditText)findViewById(R.id.dob)).getText().toString();

        String gender= ((Spinner)findViewById(R.id.gender)).getSelectedItem().toString();

        //String work_type= ((Spinner)findViewById(R.id.client_work_type)).getSelectedItem().toString();

        String son_daughter = ((EditText)findViewById(R.id.son_daughter)).getText().toString();

        String email = ((EditText)findViewById(R.id.email)).getText().toString();

        String mother = ((EditText)findViewById(R.id.mother_name)).getText().toString();

        String phone = ((EditText)findViewById(R.id.phone)).getText().toString();

        String address = ((EditText)findViewById(R.id.address)).getText().toString();

        String country = ((EditText)findViewById(R.id.country)).getText().toString();

        String state = ((EditText)findViewById(R.id.state)).getText().toString();

        String pin = ((EditText)findViewById(R.id.pin)).getText().toString();

        JSONObject to_send = new JSONObject();

        try {

            to_send.put("aadhar",aadhar);

            to_send.put("first_name",first_name);

            to_send.put("middle_name",middle_name);

            to_send.put("last_name",last_name);

            to_send.put("dob",dob);
            to_send.put("gender",gender);
            to_send.put("son-daughter",son_daughter);

            to_send.put("email",email);

            to_send.put("mother_name" ,mother);

            to_send.put("phone",phone);

            to_send.put("address",address);

            to_send.put("state",state);

            to_send.put("country",country);

            to_send.put("pin",pin);

            Log.v("test",to_send.toString());

        } catch (JSONException e) {

            e.printStackTrace();

        }

        new Register().execute(to_send);


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
    }

    public class Register extends AsyncTask<JSONObject,Void,String> {

        @Override

        protected String doInBackground(JSONObject... params) {

            OkHttpClient client = new OkHttpClient();

            RequestBody body = RequestBody.create(JSON,params[0].toString());

            Request request = new Request.Builder()

                    .url(url_worker_register)

                    .post(body)

                    .build();

            Response response = null;

            try {

                response = client.newCall(request).execute();

            } catch (IOException e) {

                e.printStackTrace();

            }

            if (response==null)

            {

                return null;}

            try {

                return response.body().string();

            } catch (IOException e) {

                e.printStackTrace();

            }

            return null;

        }

        @Override

        protected void onPostExecute(String result) {

            Toast.makeText(getApplicationContext(),"Successfully registered",Toast.LENGTH_SHORT).show();

            try{

                Log.v("test",result);}

            catch (Exception e)

            {e.printStackTrace();}

        }

    }

}
