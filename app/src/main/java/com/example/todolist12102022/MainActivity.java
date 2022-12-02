package com.example.todolist12102022;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnIntentString;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIntentString = findViewById(R.id.button_intent_string);

        btnIntentString.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, InsertActivity.class);
                intent.putExtra("title", "Thông báo");
                intent.putExtra("message", "Có dữ liệu mới");
                startActivity(intent);
            }
        });
    }
}
