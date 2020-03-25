package com.carson.androidinsperationboard;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class InsperationList extends Fragment {

    private Button mSearchButton;
    private EditText mSearchHashtagEntry;
    private RecyclerView mInspirationList;

    //TODO need adapter component

    public InsperationList() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_insperation_list, container, false);

        mSearchButton = v.findViewById(R.id.search_button);
        mSearchHashtagEntry = v.findViewById(R.id.search_hashtags_entry);
        mInspirationList = v.findViewById(R.id.inspiration_list);
        mInspirationList.setLayoutManager(new LinearLayoutManager(getActivity()));
        mSearchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSearchHashtagEntry.getText();
                //search hastags
            }
        });
        updateUI();
        return v;
    }

    @Override
    public void onResume(){
        super.onResume();
         updateUI();
    }

    private void updateUI() {
        //get inpirationLab class to getActivity
        //create liste List<Inspiration> inspirations = inspirationLab.getInspirations();

        if (mAdapter == null) {
            mAdapter = new InspirationAdapter(inspirations);
            mInspirationList.setAdapter(mAdapter);
        }else{
            mAdapter.notifyDataSetChanged();
        }
    }

    private class InspirationHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        private TextView mInspirationText;
        private TextView mInspirationHashtag;
        private TextView mInspirationDate;
        private ImageView mInspirationImage;

        private InspirationRecord mInspirationRecord;

        public InspirationHolder(LayoutInflater inflater, ViewGroup parent) {
            super(inflater.inflate(R.layout.list_item_inspiration, parent, false));
            itemView.setOnClickListener(this);
            mInspirationText = itemView.findViewById(R.id.inspiration_text);
            mInspirationHashtag = itemView.findViewById(R.id.inspiration_hashtag);
            mInspirationDate = itemView.findViewById(R.id.inspiration_date);
            mInspirationImage = itemView.findViewById(R.id.inspiration_image);
        }

        public void bind (InspirationRecord inspirationRecord){
            mInspirationRecord = inspirationRecord;

            mInspirationText.setText(mInspirationRecord.getInspiration());
            mInspirationHashtag.setText(mInspirationRecord.getHashtag());
            mInspirationDate.setText(mInspirationRecord.getDate());
            mInspirationImage.setImage(mInspirationRecord.getImage());

        }

        @Override
        public void onClick (View v) {
        Intent intent = MainActivity.newIntent(getActivity(), mInspirationRecord.getId());
        startActivity(intent);
        }
    }

    private class InspirationAdapter extends RecyclerView.Adapter<InspirationHolder> {
        private List<InspirationRecord> mInspirationRecord;

        public InspirationAdapter (List<InspirationRecord> inspirations) {mInspirationRecord = inspirations;}

        @Override
        public InspirationHolder onCreateViewHolder (ViewGroup parent, int viewType) {
            LayoutInflater layoutInflater = LayoutInflater.from(getActivity());

            return new InspirationHolder(layoutInflater, parent);
        }
    }

    @Override
    public void onBindViewHolder(InspirationHolder holder, int position){
        InspirationRecord inspirationRecord = mInspirationRecord.get(position);
        holder.bind(inspirationRecord);
    }

    @Override
    public int getItemCount() {return mInspirationRecord.size();}

}
