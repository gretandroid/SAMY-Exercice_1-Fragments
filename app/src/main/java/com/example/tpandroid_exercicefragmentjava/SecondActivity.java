package com.example.tpandroid_exercicefragmentjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SecondActivity extends AppCompatActivity {

    private Intent receivedIntent;
    public static int receivedId;
    Fragment2 fragment2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        fragment2 = (Fragment2) getSupportFragmentManager().findFragmentById(R.id.fragment2ContainerView);

        if(getIntent() != null) {
            receivedIntent = getIntent();
            receivedId = receivedIntent.getIntExtra(MainActivity.CATEGORY_INDEX, -1);
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        fragment2.populateListView(receivedId);
    }
}
