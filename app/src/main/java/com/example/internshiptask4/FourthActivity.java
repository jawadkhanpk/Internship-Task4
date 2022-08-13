package com.example.internshiptask4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class FourthActivity extends AppCompatActivity {
    public static final String RATING = "RATING";


    private String rating;


    TextView tvratingRecieved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        tvratingRecieved = findViewById(R.id.idRatingRecieved);

        dataRecievedFromThirdActivity();
    }

    private void dataRecievedFromThirdActivity() {

            Intent recievingIntent = getIntent();
            rating = recievingIntent.getStringExtra(RATING);

        Toast.makeText(this, "Rating Recieved is: "+ rating, Toast.LENGTH_SHORT).show();

        tvratingRecieved.setText("Rating: "+rating);
    }
}