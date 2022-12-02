package com.example.todolist12102022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class InsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

        // 1: String
//        Intent intent = getIntent();
//        if (intent != null) {
//            String title = intent.getStringExtra("title");
//            String message = intent.getStringExtra("message");
//            Log.d("BBB", title + "\n" + message);
//        }

        // 2: ArrayList
        Intent intent = getIntent();
        if (intent != null) {
            ArrayList<String> arrStrings = (ArrayList<String>) intent.getSerializableExtra("arrayList");
            Log.d("BBB", arrStrings.size()  + "");
        }
    }
}
