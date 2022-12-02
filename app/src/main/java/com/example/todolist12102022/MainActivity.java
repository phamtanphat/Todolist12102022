package com.example.todolist12102022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnIntentString, btnIntentArrayListString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIntentString = findViewById(R.id.button_intent_string);
        btnIntentArrayListString = findViewById(R.id.button_intent_array_list_string);

        btnIntentString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InsertActivity.class);
                intent.putExtra("title", "Thông báo");
                intent.putExtra("message", "Có dữ liệu mới");
                startActivity(intent);
            }
        });

        btnIntentArrayListString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<String> arrList = new ArrayList<>();
                arrList.add("A");
                arrList.add("B");

                Intent intent = new Intent(MainActivity.this, InsertActivity.class);
                intent.putExtra("arrayList", (Serializable) arrList);
                startActivity(intent);
            }
        });
    }
}
