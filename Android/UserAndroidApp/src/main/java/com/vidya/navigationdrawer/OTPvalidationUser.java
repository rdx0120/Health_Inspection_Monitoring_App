package com.vidya.navigationdrawer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.vidya.navigationdrawer.ui.login.ui.main.LoginDataFragment;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class OTPvalidationUser extends AppCompatActivity {
    EditText et1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_o_t_pvalidation_user);

        Button checkotp=(Button)findViewById(R.id.btn_login);
         et1=(EditText)findViewById(R.id.tv_user_name);

        checkotp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String otp=et1.getText().toString();

                if(otp.equals("")){
                    Toast.makeText(getApplicationContext(), "Please neter username or password", Toast.LENGTH_SHORT).show();

                }else {


                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    String url = UrlLinks.validateOTP;

                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);

                    nameValuePairs.add(new BasicNameValuePair("OTP", otp));

                    nameValuePairs.add(new BasicNameValuePair("username", LoginDataFragment.usernameglobal));

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


//                JSONArray jArray = null;
//                try {
//                    jArray = result.getJSONArray("jsonarrayval");
//                } catch (JSONException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//
//                System.out.println("*****JARRAY*****" + jArray.length());
//
//                for (int i = 0; i < jArray.length(); i++) {


                    JSONArray jArray = null;
//                try {
                    try {
                        jArray = result.getJSONArray("jsonarrayval");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
//                } catch (JSONException e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//
//                System.out.println("*****JARRAY*****" + jArray.length());
//
//                for (int i = 0; i < jArray.length(); i++) {


                    JSONObject json_data;

                    try {
                        json_data = jArray.getJSONObject(0);
                        String bookName = json_data.getString("bookName");
//                        String author = json_data.getString("author");
//                        String publisher = json_data.getString("publisher");

                        if (bookName.equals("1")) {

                            Intent io = new Intent(OTPvalidationUser.this, MainActivity.class);

                            startActivity(io);
                            // NavController navController= Navigation.findNavController(view);
                            // navController.navigate(R.id.nav_slideshow);


                        } else {

                            Toast.makeText(OTPvalidationUser.this, "Wrong OTP", Toast.LENGTH_SHORT).show();

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
        });
    }
}