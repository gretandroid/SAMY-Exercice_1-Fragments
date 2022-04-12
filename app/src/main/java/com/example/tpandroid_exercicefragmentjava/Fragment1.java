package com.example.tpandroid_exercicefragmentjava;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
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

public class Fragment1 extends Fragment {

    // Attributes
    MainActivity activity;
    ListView listView;

    public Fragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_1, container, false);

        // ListViewManagement
        listView = view.findViewById(R.id.fragment1ListView);
        listView.setAdapter(
                new ArrayAdapter<String>(getContext(),
                        android.R.layout.simple_list_item_1,
                        MainActivity.categories)
        );
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int index, long rowID) {
                if(MainActivity.isPortrait) {
                    // On demande à la MainActivity d'ouvrir la SecondActivity
                    activity.openSecondActivityWithId(index);
                } else {
                    // On demander à la MainActivity d'afficher simplement les données dans le
                    // Fragment2 affiché en mode Landscape
                    activity.displayDatasInFragment2WithId(index);
                }
            }
        });

        // BONUS
        colorSelectedCategory();


        return view;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        activity = (MainActivity) context;
    }

    // BONUS
    private void colorSelectedCategory() {
        listView.getAdapter().getView(MainActivity.selectedCategory, null, listView).setBackgroundColor(Color.RED);
    }
}