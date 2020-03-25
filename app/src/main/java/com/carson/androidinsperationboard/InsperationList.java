package com.carson.androidinsperationboard;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class InsperationList extends Fragment {

    private Button mSearchButton;
    private EditText mSearchHashtagEntry;
    private RecyclerView mInspirationList;

    public InsperationList() {
        // Required empty public constructor
    }

    /*
    // TODO: Rename and change types and number of parameters
    public static InsperationList newInstance(String param1, String param2) {
        InsperationList fragment = new InsperationList();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
*/
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_insperation_list, container, false);

        mSearchButton = v.findViewById(R.id.search_button);
        mSearchHashtagEntry = v.findViewById(R.id.search_hashtags_entry);
        mInspirationList = v.findViewById(R.id.inspiration_list);


        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchHashtagEntry.getText();
                //search hastags
            }
        });


        // Inflate the layout for this fragment
        return v;
    }


    /*
    @Override
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
    }*/
}
