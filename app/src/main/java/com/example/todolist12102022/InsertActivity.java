package com.example.todolist12102022;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;

import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class InsertActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);

//        btnCamera.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Check permission granted
//                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
//                    // Request permission
//                    requestPermissions(new String[]{Manifest.permission.CAMERA}, REQUEST_CODE_CAMERA);
//                } else {
//                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                    startActivityForResult(intent, REQUEST_CODE_CAMERA);
//                }
//            }
//        });
//
//        btnGallery.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                // Check permission granted
//                if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//                    // Request permission
//                    requestPermissions(new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_GALLERY);
//                } else {
//                    Intent intent = new Intent(Intent.ACTION_PICK);
//                    intent.setType("image/*");
//                    startActivityForResult(intent, REQUEST_CODE_GALLERY);
//                }
//            }
//        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        int result = grantResults[0];
//        if (result != PackageManager.PERMISSION_GRANTED) return;
//        Intent intent;
//        switch (requestCode) {
//            case REQUEST_CODE_CAMERA:
//                intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//                startActivityForResult(intent, REQUEST_CODE_CAMERA);
//                break;
//            default:
//                intent = new Intent(Intent.ACTION_PICK);
//                intent.setType("image/*");
//                startActivityForResult(intent, REQUEST_CODE_GALLERY);
//                break;
//        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        if (resultCode != RESULT_OK && data == null) return;
//        switch (requestCode) {
//            case REQUEST_CODE_CAMERA:
//                Bitmap bitmap = (Bitmap) data.getExtras().get("data");
//                img.setImageBitmap(bitmap);
//                break;
//            default:
//                try {
//                    Uri imageUri = data.getData();
//                    InputStream imageStream = getContentResolver().openInputStream(imageUri);
//                    Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
//                    img.setImageBitmap(selectedImage);
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }
//                break;
//        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
