package com.dzimbainvestmenttrustgmail.dzimba.fragmenttabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dzimbainvestmenttrustgmail.dzimba.R;

/**
 * Created by gwari on 10/19/2017.
 */

public class BeehiveFragment extends Fragment {
    public BeehiveFragment () {
        //empty constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //inflate the layout for this fragment_senga
        return inflater.inflate(R.layout.fragment_beehive, container, false);
    }
}
