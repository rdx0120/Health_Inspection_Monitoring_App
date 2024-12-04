package com.vidya.navigationdrawer;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.StrictMode;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;


public class AppointementActivity extends AppCompatActivity {

    private LinearLayout lis;
    //final List<String> fruits_list = new ArrayList<String>(Arrays.asList(fruits));
    String dateis="";
    String value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appointement);
        ArrayList<String> slotofTime=new ArrayList<>();
        lis = findViewById(R.id.listDate);
        String patient_email = getIntent().getStringExtra("key1");
        String day = getIntent().getStringExtra("key2");
         dateis = getIntent().getStringExtra("dateis");
     //   final CollectionReference addRequest = db.collection("Doctor").document(patient_email).collection("calendar").document(day).collection("hour");


        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(140, 398);
        layoutParams.setMargins(200, 0, 300, 0);



        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String url = UrlLinks.gettimeslotinformation;

        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(1);

        nameValuePairs.add(new BasicNameValuePair("dateis", dateis));


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


        JSONArray jArray = null;
        try {
            jArray = result.getJSONArray("jsonarrayval");
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        System.out.println("*****JARRAY*****" + jArray.length());

        for (int i = 0; i < jArray.length(); i++) {


            JSONObject json_data;

            try {




                json_data = jArray.getJSONObject(i);
                String bookName=json_data.getString("bookName");
                slotofTime.add(bookName);



                //                //  SplittingBooktime=bookName.split(",");

//							 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//					        		 R.layout.textview, SplittingBooktime);


                //  Toast.makeText(SelectingLcoation.this,"Doctor Available at "+ bookName, Toast.LENGTH_LONG).show();
            } catch (JSONException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

        for (int i = 8; i<19;i++){
            final int j = i;
            TextView text = new TextView(this);
            text.setText(i + ":00");
            text.setTextColor(Color.BLACK);
            text.setTextSize(20);
            LinearLayout l = new LinearLayout(this);
            l.setMinimumHeight(250);
            l.addView(text, layoutParams);

            final Button btn = new Button(this);


           btn.setText(i + ":00");
           btn.setTextColor(Color.WHITE);
           btn.setTextSize(20);
           if(slotofTime.contains(i + ":00"))
           {
               btn.setBackgroundColor(Color.RED);
               btn.setEnabled(false);

           }
           else
           {
               btn.setBackgroundColor(Color.BLUE);
               btn.setEnabled(true);
           }

            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                        String val=btn.getText().toString();
                        Toast.makeText(getApplicationContext(),val,Toast.LENGTH_LONG).show();
//                    TestingActivity.timeaccessed=val;
//                    Intent iop=new Intent(AppointementActivity.this,TestingActivity.class);
//                    iop.putExtra("dateis",dateis);
//                    iop.putExtra("timeis",val);
//                    startActivity(iop);


                        // String value = editText.getText().toString().trim();
                        Intent intent = new Intent();
                        intent.putExtra("timeis", val);
                        setResult(RESULT_OK, intent);
                        finish();
                        //  finish();

                }
            });

            l.addView(btn);
            lis.addView(l);
        }

    }


}