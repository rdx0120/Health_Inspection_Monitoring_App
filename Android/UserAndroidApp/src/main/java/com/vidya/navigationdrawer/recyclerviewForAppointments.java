package com.vidya.navigationdrawer;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.vidya.navigationdrawer.ui.home.HomeFragment;
import com.vidya.navigationdrawer.ui.slideshow.SlideshowFragment;

import java.util.List;

public class recyclerviewForAppointments extends RecyclerView.Adapter<recyclerviewForAppointments.MyViewHolder> {

    private Context mContext ;
    private List<Book> mData ;
    private ProgressBar pgsBar;
    public static String dataof="";

    public recyclerviewForAppointments(Context mContext, List<Book> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }



    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view ;
        LayoutInflater mInflater = LayoutInflater.from(mContext);
        view = mInflater.inflate(R.layout.card_main_appointment,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        holder.tv_book_title.setText(mData.get(position).getTitle());
        final String element =mData.get(position).getTitle();
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dataof=element;
                Toast.makeText(mContext, ""+element, Toast.LENGTH_SHORT).show();
//                AppCompatActivity activity = (AppCompatActivity) v.getContext();
//                HomeFragment myFragment = new HomeFragment();
//                Bundle bundle=new Bundle();
//                bundle.putString("element",element);
//
//                myFragment.setArguments(bundle);
//                activity.getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, myFragment).addToBackStack(null).commit();

            }
        });
//        holder.img_book_thumbnail.setImageResource(mData.get(position).getThumbnail());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public TextView tv_book_title,tv_card_main1_subtitle;
        public ImageView img_book_thumbnail;
        Button b1,b2;
        CardView cardView ;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_book_title = (TextView) itemView.findViewById(R.id.tv_card_main_1_title) ;
            tv_card_main1_subtitle= (TextView) itemView.findViewById(R.id.tv_card_main1_subtitle) ;
            b1=(Button) itemView.findViewById(R.id.btn_card_main1_action1) ;
            b2=(Button) itemView.findViewById(R.id.btn_card_main1_action2) ;
            b1.setVisibility(View.GONE);
            b2.setVisibility(View.GONE);
            tv_card_main1_subtitle.setVisibility(View.GONE);
            // img_book_thumbnail = (ImageView) itemView.findViewById(R.id.book_img_id);
            cardView = (CardView) itemView.findViewById(R.id.card_main_appoint);


        }
    }


}