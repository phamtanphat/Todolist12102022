package com.example.todolist12102022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Button btnIntentString, btnIntentSerializable, btnIntentParcelable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIntentString = findViewById(R.id.button_intent_string);
        btnIntentSerializable = findViewById(R.id.button_intent_serializable);
        btnIntentParcelable = findViewById(R.id.button_intent_parcelable);

        btnIntentString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InsertActivity.class);
                intent.putExtra("title", "Thông báo");
                intent.putExtra("message", "Có dữ liệu mới");
                startActivity(intent);
            }
        });

        btnIntentSerializable.setOnClickListener(new View.OnClickListener() {
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

        btnIntentParcelable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Person person = new Person("Teo", "5");
                Intent intent = new Intent(MainActivity.this, InsertActivity.class);
                intent.putExtra("person", person);
                startActivity(intent);
            }
        });
    }
}
