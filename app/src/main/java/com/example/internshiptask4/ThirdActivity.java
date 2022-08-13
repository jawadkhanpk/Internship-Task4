package com.example.internshiptask4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {

    private String name;            // strings to hold data that is received from secondActivity
    private String fatherName;      // strings to hold data that is received from secondActivity
    private String gender;     // strings to hold data that is received from secondActivity
    private String age;     // strings to hold data that is received from secondActivity
    private String city;     // strings to hold data that is received from secondActivity
    private String pickeddate;     // strings to hold data that is received from secondActivity
    private String uriToString;   // strings to hold data that is received from secondActivity


    public  static final String NAME = "NAME";
    public  static final String FATHERNAME = "FATHERNAME";
    public  static final String GENDER = "GENDER";
    public  static final String AGE = "AGE";
    public  static final String CITY = "CITY";
    public  static final String DATE = "DATE";
    public  static final String IMAGE = "IMAGE";



    TextView tvName;
    TextView tvFatherName;
    TextView tvGender;
    TextView tvAge;
    TextView tvCity;
    TextView tvDate;
    ImageView ivprofileImageThirdActivity;


    RatingBar ratingBar;
    Button btnSubmittRating;
    String  rating;
    public  static final String RATING = "RATING";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        recievedDataFromSecondActivity();

        tvName = findViewById(R.id.idTvName);
        tvFatherName = findViewById(R.id.idTvFatherName);
        tvGender = findViewById(R.id.idTvGender);
        tvAge = findViewById(R.id.idTvAge);
        tvCity = findViewById(R.id.idTvCity);
        tvDate = findViewById(R.id.idTvDate);
        ivprofileImageThirdActivity = findViewById(R.id.idIvProfileThirdActivity);

        ratingBar = findViewById(R.id.idRatingBar);
        btnSubmittRating = findViewById(R.id.idbtnsubmittRating);

        Uri stringToUri = Uri.parse(uriToString);
        ivprofileImageThirdActivity.setImageURI(stringToUri);


        // setting data to texviews and image views
        tvName.setText("HI: "+name);
        tvFatherName.setText("Your Father Name is: "+fatherName);
        tvGender.setText("Your Gender is: "+gender);
        tvAge.setText("Your Age is: "+age);
        tvCity.setText("Your City is: "+city);
        tvDate.setText("The Date you picked: "+pickeddate);
        ivprofileImageThirdActivity.setImageURI(stringToUri);


        btnSubmittRating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submittRating();
            }
        });
    }


    private void recievedDataFromSecondActivity() {

        Intent recievingIntent = getIntent();
        name = recievingIntent.getStringExtra(NAME);
        fatherName = recievingIntent.getStringExtra(FATHERNAME);
        gender = recievingIntent.getStringExtra(GENDER);
        age = recievingIntent.getStringExtra(AGE);
        city = recievingIntent.getStringExtra(CITY);
        pickeddate = recievingIntent.getStringExtra(DATE);
        uriToString = recievingIntent.getStringExtra(IMAGE);
    }

    private void submittRating() {
        rating = String.valueOf(ratingBar.getRating());

//        Toast.makeText(this, "Stars are: " +rating, Toast.LENGTH_SHORT).show();

        Intent sendDataToFourthActivity = new Intent(ThirdActivity.this, FourthActivity.class);
        sendDataToFourthActivity.putExtra(ThirdActivity.RATING,rating);
        startActivity(sendDataToFourthActivity);



    }
}