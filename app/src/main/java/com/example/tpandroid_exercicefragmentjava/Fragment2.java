package com.example.tpandroid_exercicefragmentjava;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class Fragment2 extends Fragment {

    // Attributes
    ListView listView;

    public Fragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_2, container, false);
        listView = view.findViewById(R.id.fragment2ListView);

        return view;
    }

    public void populateListView(int id) {
        // ListViewManagement
        listView.setAdapter(new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1,
                MainActivity.articles[id])
        );
    }
}