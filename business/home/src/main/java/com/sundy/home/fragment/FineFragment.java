package com.sundy.home.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sundy.home.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FineFragment extends Fragment {


    public FineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.bbl_fgt_fine_layout, container, false);
    }

}
