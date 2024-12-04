package com.vidya.navigationdrawer;

import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.os.StrictMode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.vidya.navigationdrawer.ui.login.ui.main.LoginDataFragment;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class UserproblemFragment extends Fragment {

    private UserproblemViewModel mViewModel;

    public static UserproblemFragment newInstance() {
        return new UserproblemFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
       View root= inflater.inflate(R.layout.userproblem_fragment, container, false);
        Context context = root.getContext();
        final TextView t1 = root.findViewById(R.id.textView4);
        final EditText usernames = root.findViewById(R.id.tv_user_name);
        final EditText passwords = root.findViewById(R.id.tv_password);
        final Button b1=root.findViewById(R.id.btn_login);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=usernames.getText().toString();
                String password=passwords.getText().toString();

                //usernames.setText("");
               // passwords.setText("");
                if(username.equals("")||password.equals("")){
                    Toast.makeText(getActivity(), "Please neter question or answer", Toast.LENGTH_SHORT).show();

                }else {


                    StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
                    StrictMode.setThreadPolicy(policy);
                    String url = UrlLinks.checkuserconcern;

                    List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(3);

                    nameValuePairs.add(new BasicNameValuePair("subject", username));
                    nameValuePairs.add(new BasicNameValuePair("concern", password));
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




                    try {
//                        json_data = jArray.getJSONObject(i);
//                        String bookName = result.getString("bookName");
//                        String author = json_data.getString("author");
//                        String publisher = json_data.getString("publisher");
                        JSONArray jArray = null;
                        try {
                            jArray = result.getJSONArray("jsonarrayval");
                        } catch (JSONException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }

                        JSONObject  json_data = jArray.getJSONObject(0);
                        String bookName = json_data.getString("bookName");

                        if (bookName.equals("1")) {
                            Toast.makeText(getActivity(), "Successfully added your concern", Toast.LENGTH_SHORT).show();

                        }
                        else
                        {
                            Toast.makeText(getActivity(), "something went wrong", Toast.LENGTH_SHORT).show();

                        }
                         } catch (JSONException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }

                }


            }
        });


        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(UserproblemViewModel.class);
        // TODO: Use the ViewModel
    }

}