package com.example.internshiptask4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;


//  recieved data from MainActivity
import static com.example.internshiptask4.MainActivity.NAME;
import static com.example.internshiptask4.MainActivity.FATHERNAME;
import static com.example.internshiptask4.MainActivity.IMAGE;


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

        recievedataFromFirstActivity();

    }

    private void recievedataFromFirstActivity() {

        Intent recievingIntent = getIntent();
        name = recievingIntent.getStringExtra(NAME);
        fatherName = recievingIntent.getStringExtra(FATHERNAME);
        uriToString = recievingIntent.getStringExtra(IMAGE);

        Uri stringToUri = Uri.parse(uriToString);
        Toast.makeText(this, "stringToUri is: "+stringToUri ,Toast.LENGTH_SHORT).show();
        ivtest.setImageURI(stringToUri);

    }

}