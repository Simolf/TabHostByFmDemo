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
public class messageFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View Msg= inflater.inflate(R.layout.message_layout,container,false);
        return Msg;
    }
}
