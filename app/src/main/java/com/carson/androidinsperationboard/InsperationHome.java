package com.carson.androidinsperationboard;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;


public class InsperationHome extends Fragment {

    private static final String TAG = "INSPERATION_HOME";

    private InspirationViewModel insperationViewModel;
    private InspirationRecord inspirationRecord;

    //components
    private EditText mEnterInspiration;
    private EditText mEnterHashtag;
    private ImageView mInspirationThumbnail;
    private Button mTakePictureButton;
    private Button mInspirationListButton;
    private Button mSaveInspirationButton;
    private String mDate;


    private static int REQUEST_CODE_TAKE_PICTURE = 0;

    public InsperationHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_insperation_home, container, false);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");

        mEnterInspiration = v.findViewById(R.id.enter_inspiration);
        mEnterHashtag = v.findViewById(R.id.enter_hashtag);
        mInspirationThumbnail = v.findViewById(R.id.inspiration_thumbnail);
        mTakePictureButton = v.findViewById(R.id.take_picture_button);
        mSaveInspirationButton = v.findViewById(R.id.save_inspiration_button);
        mInspirationListButton = v.findViewById(R.id.view_inspiration_list_button);

        mDate = sdf.format(new Date());

        mTakePictureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                takeInspirationPicture();
            }
        });

        mSaveInspirationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveInspiration();
            }
        });

        mInspirationListButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                goToInspirationFragment();
            }
        });


        return v;
    }

    private void takeInspirationPicture() {
        Intent pictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        if (pictureIntent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(pictureIntent, REQUEST_CODE_TAKE_PICTURE);
        } else {
            Toast.makeText(this, "Your device does not have a camera app", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        if (requestCode == REQUEST_CODE_TAKE_PICTURE && resultCode == REULTS_OK){
            Bitmap thumbnail = data.getParcelableExtra("data");
            mInspirationThumbnail.setImageBitmap(thumbnail);
        }
    }

    private void saveInspiration(){
        mEnterInspiration.getText().toString();
        mEnterHashtag.getText().toString();
        //mInspirationThumbnail.

        //set records
        inspirationRecord.setDate(mDate);
        inspirationRecord.setInspiration(mEnterInspiration);
        inspirationRecord.setHashtag(mEnterHashtag);
        inspirationRecord.setBitmap(mInspirationThumbnail);
        insperationViewModel.update(inspirationRecord);

        Log.d(TAG,"Updated insperation record");

        //clear fields

        mEnterInspiration.getText().clear();
        mEnterHashtag.getText().clear();
        mInspirationThumbnail.getBitmap().clear();

    }

    private void goToInspirationFragment(){
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        ft.replace(R.id.fragment_container, insperationList);
        ft.addToBackStack(null);
        ft.commit();
    }


}
