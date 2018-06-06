package com.example.yrw.myapplication3;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class FenFragment extends Fragment {
    int id;
    /*public static FenFragment newInstance(int id) {
        FenFragment newFragment = new FenFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("id",id);
        newFragment.setArguments(bundle);
        return newFragment;
    }*/
    public FenFragment(){
    }
    public FenFragment(int id){
        this.id=id;
    }
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(id, null);
        return view;
    }
}
