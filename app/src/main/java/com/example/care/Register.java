package com.example.care;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class Register extends AppCompatActivity {

    private final String API="http://ec2-35-154-142-209.ap-south-1.compute.amazonaws.com:8000/api/rest-auth/registration/";

    private EditText userName,eMail,password;

    private Button register;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        setTitle("Sign Up");

        final RequestQueue queue = Volley.newRequestQueue(this);

        userName = findViewById(R.id.username);
        eMail = findViewById(R.id.email);
        password = findViewById(R.id.password);
        register = findViewById(R.id.register);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(userName.getText().toString().isEmpty() || eMail.getText().toString().isEmpty() || password.getText().toString().isEmpty() )
                {
                    Toast.makeText(Register.this,"Please Enter Valid Details",Toast.LENGTH_SHORT).show();
                }
                else
                {
                    getRegistered(userName.getText().toString(),eMail.getText().toString(),password.getText().toString(),queue);
                }
            }
        });
    }

    private void getRegistered(String userName, String eMail, String password, RequestQueue queue)
    {
        Map<String,String> params = new HashMap<>();
        params.put("username",userName);
        params.put("email",eMail);
        params.put("password1",password);
        params.put("password2",password);
        final JSONObject jsonObject = new JSONObject(params);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.POST, API, jsonObject, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {

                try {
                    JSONObject jsonObject1 = new JSONObject(response.toString());
                    String key = jsonObject1.getString("key");
                    Toast.makeText(Register.this,"Key ID :" +key,Toast.LENGTH_SHORT).show();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Register.this,error.toString(),Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonObjectRequest);
    }
}
