package com.example.internshiptask4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.drjacky.imagepicker.ImagePicker;

public class MainActivity extends AppCompatActivity {

    ImageView pickImgfromGallery;       // vector to pick image from the gallery
    ImageView profilePicture;           // placeholder where we show picked or chosen image

    Button btnNextActivity1;



    EditText etName;
    EditText etFatherName;

    private String name;
    private String fatherName;
    private Uri uri;    // image Uri global variable
    private String uritostring=null;     // to convert uri to string

    public  static final String NAME = "NAME";
    public  static final String FATHERNAME = "FATHERNAME";
    public  static final String IMAGE = "IMAGE";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pickImgfromGallery = findViewById(R.id.idPickImgFromGallery);
        profilePicture = findViewById(R.id.idProfilePicture);

        btnNextActivity1 = findViewById(R.id.idbtnnext);

        etName = findViewById(R.id.idEtName);
        etFatherName = findViewById(R.id.idEtFatherName);


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

        btnNextActivity1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String imge = profilePicture.getDrawable().toString(); //
                Toast.makeText(getApplicationContext(),"" +imge,Toast.LENGTH_SHORT).show();
                if (profilePicture.getDrawable().toString().equals ("android.graphics.drawable.BitmapDrawable@7479c6f")){
                    Log.d("TAG",imge);
                    Toast.makeText(getApplicationContext(),"Please Select Image!",Toast.LENGTH_SHORT).show();
                }else if (etName.getText().toString().equals("")) {
                    etName.setError("Name is Required");
                }else if (etFatherName.getText().toString().equals("")){
                    etFatherName.setError("Father Name is Required");
                } else {
                    name = etName.getText().toString().trim();
                    fatherName = etFatherName.getText().toString().trim();
                    uritostring = uri.toString();
                    Log.d("TAG", "uri=" + uritostring);
                    sendDatatoSecondActivity();
                }

            }
        });

    }

    private void sendDatatoSecondActivity() {


            Intent sendingIntent = new Intent(MainActivity.this, SecondActivity.class);
            sendingIntent.putExtra(MainActivity.NAME,name); // sends data to second activity
            sendingIntent.putExtra(MainActivity.FATHERNAME,fatherName);  // sends data to second activity
            sendingIntent.putExtra(MainActivity.IMAGE,uritostring); // sends data to second activity
            startActivity(sendingIntent);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        uri = data.getData();
        profilePicture.setImageURI(uri);

    }
}