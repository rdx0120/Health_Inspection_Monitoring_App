package com.vidya.navigationdrawer;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.vidya.navigationdrawer.ui.login.LoginData;
import com.vidya.navigationdrawer.ui.login.ui.main.LoginDataFragment;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class RegisterUser extends AppCompatActivity {
    Button login,register;
    EditText et1,et2,et3,et4,et5,et6,et7,et8,et9,et10,et11,et12,et13;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.registration);
       // login=(Button)findViewById(R.id.button5);
        register=(Button)findViewById(R.id.btn_login);
        et1=(EditText)findViewById(R.id.tv_user_name);
        et2=(EditText)findViewById(R.id.tv_password);
        et3=(EditText)findViewById(R.id.editTextTextEmailAddress);
        et4=(EditText)findViewById(R.id.editTextPhone);
        et11=(EditText)findViewById(R.id.editTextAddress);
        et5=(EditText)findViewById(R.id.editTextAbout);
        et6=(EditText)findViewById(R.id.editTextAvailability);
        et7=(EditText)findViewById(R.id.editTexteducation);
        et8=(EditText)findViewById(R.id.editTextOperation);
        et9=(EditText)findViewById(R.id.editTextSpecilization);
        et10=(EditText)findViewById(R.id.editTextHospitalname);
//        et11=(EditText)findViewById(R.id.editTextTextEmailAddress);
//        et12=(EditText)findViewById(R.id.editTextPhone);
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent io = new Intent(RegisterUser.this, LoginDataFragment.class);
//
//                startActivity(io);
//                finish();
//            }
//        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username=et1.getText().toString();
                String password=et2.getText().toString();
                String mobilenumber=et4.getText().toString();
                String address=et11.getText().toString();
                String email=et3.getText().toString();
                String about=et5.getText().toString();
                String availability=et6.getText().toString();
                String education=et7.getText().toString();
                String operation=et8.getText().toString();
                String specilization=et9.getText().toString();
                String hospitalname=et10.getText().toString();
                String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
                if(username.equals("")||password.equals("")||mobilenumber.equals("")||address.equals("")
                        ||email.equals("")||about.equals("")||availability.equals("")
                        ||education.equals("")||operation.equals("") ||specilization.equals("")||hospitalname.equals("")){
                    Toast.makeText(RegisterUser.this, "Please enter all details", Toast.LENGTH_SHORT).show();

                }
                if(username.length()<8)
                {
                    Toast.makeText(getApplicationContext(),"username must be of 8 alphabates",Toast.LENGTH_SHORT).show();
                }
                else if(password.length()<8)
                {
                    Toast.makeText(getApplicationContext(),"Password must be of 8 alphabates",Toast.LENGTH_SHORT).show();
                }
                else if(mobilenumber.length()!=10)
                {
                    Toast.makeText(getApplicationContext(),"Phone number should be of 10 digits",Toast.LENGTH_SHORT).show();
                }
                else if (!email.matches(emailPattern) )
                {
                    Toast.makeText(getApplicationContext(),"invalid email address",Toast.LENGTH_SHORT).show();
                    // or
                    // textView.setText("valid email");
                }

                else {


                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    String url = UrlLinks.checkregistration;

                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(10);

                    nameValuePairs.add(new BasicNameValuePair("doctorname", username));
                    nameValuePairs.add(new BasicNameValuePair("password", password));
                    nameValuePairs.add(new BasicNameValuePair("email", email));
                    nameValuePairs.add(new BasicNameValuePair("phonenumber", mobilenumber));
                    nameValuePairs.add(new BasicNameValuePair("address", address));
                    nameValuePairs.add(new BasicNameValuePair("Specilization", specilization));
                    nameValuePairs.add(new BasicNameValuePair("availability", availability));
                    nameValuePairs.add(new BasicNameValuePair("education", education));
                    nameValuePairs.add(new BasicNameValuePair("operation", operation));
                    nameValuePairs.add(new BasicNameValuePair("about", about));
                    nameValuePairs.add(new BasicNameValuePair("hospitalname", hospitalname));

                    JSONObject result = null;
                    try {
                        result = jSOnClassforData.forCallingServer(url, nameValuePairs);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

//        JSONArray jArray = new JSONArray(result.toString());
//
//        for(int i=0;i<jArray.length();i++) {
//            String alldata = jArray.get(i).toString();
//
//            String datasplit[] = alldata.split("_");
//            latilongidata.add(alldata);
//
//
//
//
//        }


//                    JSONArray jArray = null;
//                    try {
//                        jArray = result.getJSONArray("jsonarrayval");
//                    } catch (JSONException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
//
//                    System.out.println("*****JARRAY*****" + jArray.length());
//
//                    for (int i = 0; i < jArray.length(); i++) {


                    JSONArray jArray = null;
                    try {
                        jArray = result.getJSONArray("jsonarrayval");
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
//
//                    System.out.println("*****JARRAY*****" + jArray.length());
//
//                    for (int i = 0; i < jArray.length(); i++) {


                    JSONObject json_data;

                    try {
                        json_data = jArray.getJSONObject(0);
                        String bookName = json_data.getString("bookName");
//                        String author = json_data.getString("author");
//                        String publisher = json_data.getString("publisher");

                        if (bookName.equals("1")) {
                            Toast.makeText(RegisterUser.this, "User Added successfully", Toast.LENGTH_SHORT).show();

                            Intent io = new Intent(RegisterUser.this, LoginData.class);

                            startActivity(io);
                            finish();

                        } else {

                            Toast.makeText(RegisterUser.this, "User not added", Toast.LENGTH_SHORT).show();

                        }


                        //  SplittingBooktime=bookName.split(",");

//							 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//					        		 R.layout.textview, SplittingBooktime);


                        //  Toast.makeText(SelectingLcoation.this,"Doctor Available at "+ bookName, Toast.LENGTH_LONG).show();
                    } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                    }


                }

//            }
        });
    }

    }
