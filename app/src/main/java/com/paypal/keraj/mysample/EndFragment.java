package com.paypal.keraj.mysample;

/**
 * Created by keraj on 8/10/2015.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class EndFragment extends Fragment {

    public EndFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_end, container, false);
        return rootView;
    }
}

