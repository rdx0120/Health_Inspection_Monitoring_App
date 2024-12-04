package com.vidya.navigationdrawer.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProviders;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.vidya.navigationdrawer.R;
import com.vidya.navigationdrawer.TestingActivity;
import com.vidya.navigationdrawer.chatapponetone.LoginChatActivity;
import com.vidya.navigationdrawer.chatapponetone.StartActivity;

import java.util.List;

public class ChatFragment extends Fragment {

    private ChatViewModel mViewModel;

    public static ChatFragment newInstance() {
        return new ChatFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.chat_fragment, container, false);
      List<ApplicationInfo> apps = getContext().getPackageManager().getInstalledApplications(0);
//        getContext().getPackageManager().getLaunchIntentForPackage("com.vidya.chatapponetone");


//        Intent intent = new Intent(Intent.ACTION_MAIN);
//        intent.setComponent(new ComponentName("com.vidya.chatapponetone","com.vidya.chatapponetone.StartActivity"));
//        startActivity(intent);



//        Intent intent = new Intent(Intent.ACTION_MAIN);
//        intent.setClassName("com.vidya.chatapponetone", "com.vidya.chatapponetone.StartActivity");
//        startActivity(intent);

        AppCompatActivity activity = (AppCompatActivity) root.getContext();
        Intent myIntent = new Intent(activity, StartActivity.class);

        activity.startActivity(myIntent);



//        Intent intent = getContext().getPackageManager().getLaunchIntentForPackage("com.vidya.chatapponetone");
//        if (intent != null) {
//            // We found the activity now start the activity
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            startActivity(intent);
//        } else {
//            // Bring user to the market or let them choose an app?
//            intent = new Intent(Intent.ACTION_VIEW);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//            intent.setData(Uri.parse("market://details?id=" + "com.vidya.chatapponetone"));
//            startActivity(intent);
//        }

//        Intent intent = new Intent().setClassName(getContext(), "com.vidya.chatapponetone.StartActivity");
//        getContext().startActivity(intent);

//        Intent intent = new Intent("com.vidya.chatapponetone.StartActivity");
//        startActivity(intent);

//        String appName = "Gmail";
//        String packageName = "com.android.providers.calendar";
//        openApp(getContext(), appName, packageName);




//        Intent intent =  getActivity().getPackageManager().getLaunchIntentForPackage("com.vidya.navigationdrawer");
//        startActivity(intent);
        return root;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(ChatViewModel.class);
        // TODO: Use the ViewModel
    }
    public static void openApp(Context context, String appName, String packageName) {
        if (isAppInstalled(context, packageName))
            if (isAppEnabled(context, packageName))
                context.startActivity(context.getPackageManager().getLaunchIntentForPackage(packageName));
            else Toast.makeText(context, appName + " app is not enabled.", Toast.LENGTH_SHORT).show();
        else Toast.makeText(context, appName + " app is not installed.", Toast.LENGTH_SHORT).show();
    }

    private static boolean isAppInstalled(Context context, String packageName) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo(packageName, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException ignored) {
        }
        return false;
    }

    private static boolean isAppEnabled(Context context, String packageName) {
        boolean appStatus = false;
        try {
            ApplicationInfo ai = context.getPackageManager().getApplicationInfo(packageName, 0);
            if (ai != null) {
                appStatus = ai.enabled;
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return appStatus;
    }
}