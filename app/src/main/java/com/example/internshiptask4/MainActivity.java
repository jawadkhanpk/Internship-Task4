package com.example.internshiptask4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.drjacky.imagepicker.ImagePicker;

public class MainActivity extends AppCompatActivity {

    ImageView pickImgfromGallery;
    ImageView profilePicture;

    Button next;

    Uri uri;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pickImgfromGallery = findViewById(R.id.idPickImgFromGallery);
        profilePicture = findViewById(R.id.idProfilePicture);

        next = findViewById(R.id.idbtnnext);

        pickImgfromGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ImagePicker.Companion.with(MainActivity.this)
                        .crop()
                        .cropOval()
                        .compress(1024)
                        .maxResultSize(1080, 1080)
                        .start();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Image Uri: "+ uri,  Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        uri = data.getData();
        profilePicture.setImageURI(uri);

    }
}