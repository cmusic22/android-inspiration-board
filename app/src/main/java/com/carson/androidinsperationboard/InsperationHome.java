package com.carson.androidinsperationboard;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;


public class InsperationHome extends Fragment {

    //components
    private EditText mEnterInpiration;
    private EditText mEnterHashtag;
    private ImageView mInspirationThumbnail;
    private Button mTakePictureButton;
    private Button mInspirationListButton;
    private Button mSaveInspirationButton;


    private static int REQUEST_CODE_TAKE_PICTURE = 0;

    public InsperationHome() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    /*public static InsperationHome newInstance(String param1, String param2) {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }*/

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_insperation_home, container, false);

        mEnterInpiration = v.findViewById(R.id.enter_inspiration);
        mEnterHashtag = v.findViewById(R.id.enter_hashtag);
        mInspirationThumbnail = v.findViewById(R.id.inspiration_thumbnail);
        mTakePictureButton = v.findViewById(R.id.take_picture_button);
        mSaveInspirationButton = v.findViewById(R.id.save_inspiration_button);
        mInspirationListButton = v.findViewById(R.id.view_inspiration_list_button);

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

    private void saveInspiration(){
        //save inspiration
    }

    private void goToInspirationFragment(){
        //go to Insperation List
    }


    /*@Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }*/
}
