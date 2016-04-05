package com.example.cxx.tabhostbyfmdemo;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by CXX on 2016/4/5.
 */
public class MainFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root1 = inflater.inflate(R.layout.main_layout,container,false);
        return root1;
    }
}
