package com.carson.androidinsperationboard;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class InsperationDetail extends Fragment {


    private TextView mInsperationText;
    private TextView mHashtagText;
    private ImageView mInspirationPhotoDetail;
    private Button mHomeButton;
    private Button mDeleteButton;


    public InsperationDetail() {
        // Required empty public constructor
    }


    /*/ TODO: Rename and change types and number of parameters
    public static InsperationDetail newInstance(String param1, String param2) {
        InsperationDetail fragment = new InsperationDetail();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_insperation_detail, container, false);

        mInsperationText = v.findViewById(R.id.inspiration_text);
        mHashtagText = v.findViewById(R.id.hashtag_text);
        mInspirationPhotoDetail = v.findViewById(R.id.inspiration_photo_detail);
        mHomeButton = v.findViewById(R.id.home_button);
        mDeleteButton = v.findViewById(R.id.delete_button);


        //image, inspiration & hashtag text will be served in the saved state

        mHomeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //bring user to home fragment
            }
        });

        mDeleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //delete inspiration from database
            }
        });







        // Inflate the layout for this fragment
        return v;
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
*/



}
