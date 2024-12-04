package com.vidya.navigationdrawer.ui.slideshow;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vidya.navigationdrawer.Book;
import com.vidya.navigationdrawer.R;
import com.vidya.navigationdrawer.UrlLinks;
import com.vidya.navigationdrawer.recyclerviewForAppointments;
import com.vidya.navigationdrawer.ui.login.LoginData;
import com.vidya.navigationdrawer.ui.login.ui.main.LoginDataFragment;
import com.vidya.navigationdrawer.viewDoctorslist;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class SlideshowFragment extends Fragment {
    List<Book> lstBook ;
    private SlideshowViewModel slideshowViewModel;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        loaddata();

    }
    private void loaddata() {
        lstBook = new ArrayList<>();

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        String url = UrlLinks.loadDoctorData;





        JSONObject result = null;

        try {
            HttpGetRequest getRequest = new HttpGetRequest();
            //Perform the doInBackground method, passing in our url



            Map<String, String> request = new HashMap<String, String>();

            String result1="";


            String dataurl = buildSanitizedRequest(url, request);
            result1 = getRequest.execute(dataurl).get();
            result=new JSONObject(result1);


        } catch (JSONException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
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


        JSONObject json_data;

        try {
//                        json_data = jArray.getJSONObject(i);
            //  String bookName = result.getString("bookName");

            JSONArray jArray = null;
            jArray = result.getJSONArray("bookName");
            System.out.println("*****JARRAY*****" + jArray);

            for(int k=0;k<jArray.length();k++)
            {
                lstBook.add(new Book(jArray.getString(k),"Categorie Book","Description book",R.drawable.ic_launcher_background));

            }

//                        String author = json_data.getString("author");
//                        String publisher = json_data.getString("publisher");




//        String  SplittingBooktime=bookName.split(",");
//
//							 ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//					        		 R.layout.textview, SplittingBooktime);


//          Toast.makeText(SelectingLcoation.this,"Doctor Available at "+ bookName, Toast.LENGTH_LONG).show();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }








//        lstBook.add(new Book("Docotr1","Categorie Book","Description book",R.drawable.ic_launcher_background));
//
//        lstBook.add(new Book("Docotr2","Categorie Book","Description book",R.drawable.ic_launcher_background));
//        lstBook.add(new Book("Docotr3","Categorie Book","Description book",R.drawable.ic_launcher_background));
//        lstBook.add(new Book("Docotr4","Categorie Book","Description book",R.drawable.ic_launcher_background));
//        lstBook.add(new Book("Docotr5","Categorie Book","Description book",R.drawable.ic_launcher_background));

       // lstBook.add(new Book("Docotr6","Categorie Book","Description book",R.drawable.ic_launcher_background));
        //




    }
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                ViewModelProviders.of(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        RecyclerView myrv = (RecyclerView) root.findViewById(R.id.recyclerView);
        viewDoctorslist myAdapter = new viewDoctorslist(getContext(),lstBook);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 1);
//        myrv.setLayoutManager(gridLayoutManager);
//        myrv.setAdapter(myAdapter);
        Intent loginActivity = new Intent(getContext(), LoginData.class);
        startActivity(loginActivity);
        getActivity().finish();



        return root;
    }
    public class HttpGetRequest extends AsyncTask<String, Void, String> {
        public static final String REQUEST_METHOD = "POST";
        public static final int READ_TIMEOUT = 15000;
        public static final int CONNECTION_TIMEOUT = 15000;





        @Override
        protected String doInBackground(String... params){



            String stringUrl = params[0];
            String result;
            String inputLine;
            try {
                //Create a URL object holding our url
                URL myUrl = new URL(stringUrl);
                //Create a connection
                HttpURLConnection connection =(HttpURLConnection)
                        myUrl.openConnection();
                //Set methods and timeouts
                connection.setRequestMethod(REQUEST_METHOD);
                connection.setReadTimeout(READ_TIMEOUT);
                connection.setConnectTimeout(CONNECTION_TIMEOUT);

                //Connect to our url
                connection.connect();
                //Create a new InputStreamReader
                InputStreamReader streamReader = new
                        InputStreamReader(connection.getInputStream());
                //Create a new buffered reader and String Builder
                BufferedReader reader = new BufferedReader(streamReader);
                StringBuilder stringBuilder = new StringBuilder();
                //Check if the line we are reading is not null
                while((inputLine = reader.readLine()) != null){
                    stringBuilder.append(inputLine);
                }
                //Close our InputStream and Buffered reader
                reader.close();
                streamReader.close();
                //Set our result equal to our stringBuilder
                result = stringBuilder.toString();
            }
            catch(IOException e){
                e.printStackTrace();
                result = null;
            }
            return result;
        }
        @Override
        protected void onPostExecute(String result){
            super.onPostExecute(result);
//            if(prDialog!=null) {
//                prDialog.dismiss();
//            }

        }
    }

    private static String buildSanitizedRequest(String url,
                                                Map<String, String> mapOfStrings) {

        Uri.Builder uriBuilder = new Uri.Builder();
        uriBuilder.encodedPath(url);
        if (mapOfStrings != null) {
            for (Map.Entry<String, String> entry : mapOfStrings.entrySet()) {
                Log.d("buildSanitizedRequest", "key: " + entry.getKey()
                        + " value: " + entry.getValue());
                uriBuilder.appendQueryParameter(entry.getKey(),
                        entry.getValue());
            }
        }
        String uriString;
        try {
            uriString = uriBuilder.build().toString(); // May throw an
            // UnsupportedOperationException
        } catch (Exception e) {
            Log.e("Exception", "Exception" + e);
        }

        return uriBuilder.build().toString();

    }
}
