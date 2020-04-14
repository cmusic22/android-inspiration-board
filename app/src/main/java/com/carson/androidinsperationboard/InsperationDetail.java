package com.carson.androidinsperationboard;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;


public class InsperationDetail extends Fragment {

    private static final String TAG = "INSPERATION_DETAIL";
    //need to get database string/key
    private InsperationHome insperationHome;

    private TextView mInsperationText;
    private TextView mHashtagText;
    private ImageView mInspirationPhotoDetail;
    private Button mHomeButton;
    private Button mDeleteButton;



    public InsperationDetail() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_insperation_detail, container, false);
        //pull in ability to target insperationHome = v.find

        mInsperationText = v.findViewById(R.id.inspiration_text);
        mHashtagText = v.findViewById(R.id.hashtag_text);
        mInspirationPhotoDetail = v.findViewById(R.id.inspiration_photo_detail);
        mHomeButton = v.findViewById(R.id.home_button);
        mDeleteButton = v.findViewById(R.id.delete_button);

        mInsperationText.setText(InspirationRecord.getInspiration());
        mHashtagText.setText(InspirationRecord.getHashtag());
        mInspirationPhotoDetail.setImageBitmap(InspirationRecord.getBitmap());

        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                bringHome();
            }
        });

        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteInspiration(mDate);
            }
        });


        // Inflate the layout for this fragment
        return v;
    }


    private void bringHome() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.fragment_container, insperationHome);
        ft.addToBackStack(null);
        ft.commit();
    }

    private void deleteInspiration(Date date){

        InspirationDAO.deleteInspiration (date);

        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.fragment_container, insperationHome);
        ft.addToBackStack(null);
        ft.commit();
    }

}
