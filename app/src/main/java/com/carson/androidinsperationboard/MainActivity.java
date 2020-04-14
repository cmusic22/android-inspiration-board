package com.carson.androidinsperationboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;

import android.os.Bundle;
import android.util.Log;

import java.util.Date;
import java.util.List;

public class MainActivity extends AppCompatActivity implements InsperationHome, InsperationList, InsperationDetail {

    private InsperationHome insperationHome;
    private InspirationViewModel inspirationViewModel;

    private static final String TAG = "MAIN_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

    }

}
