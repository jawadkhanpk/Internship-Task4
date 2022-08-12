package com.example.internshiptask4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import static com.example.internshiptask4.MainActivity.FATHERNAME;
import static com.example.internshiptask4.MainActivity.IMAGE;
import static com.example.internshiptask4.MainActivity.NAME;


public class SecondActivity extends AppCompatActivity {

    ImageView ivtest;

    private String name;
    private String fatherName;
    private String uriToString;    // image Uri global variable

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        ivtest = findViewById(R.id.imageView);




        Intent recievingIntent = getIntent();
        name = recievingIntent.getStringExtra(NAME);
        fatherName = recievingIntent.getStringExtra(FATHERNAME);
        uriToString = recievingIntent.getStringExtra(IMAGE);

//       Toast.makeText(this, "Image Uri Recieved: "+uriToString, Toast.LENGTH_SHORT).show();


        Uri convertedUri = Uri.parse(uriToString);
        Toast.makeText(this, "conveted Uri: "+convertedUri ,Toast.LENGTH_SHORT).show();
        ivtest.setImageURI(convertedUri);

    }

}