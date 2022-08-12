package com.example.internshiptask4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


////////////////////////////recieved data from MainActivity /////////////////////////////////
import java.text.SimpleDateFormat;
import java.util.Calendar;

import static com.example.internshiptask4.MainActivity.NAME;
import static com.example.internshiptask4.MainActivity.FATHERNAME;
import static com.example.internshiptask4.MainActivity.IMAGE;
///////////////////////////////////////////////////////////////////////////////////////////////


public class SecondActivity extends AppCompatActivity {


    private String name;
    private String fatherName;
    private String uriToString;


    Button btnDatePicker;
    int year;
    int month;
    int day;
    TextView tvpickeddate;

    RadioGroup radiogroup;
    RadioButton radioButton;

    String radiobuttonmalefemale;   // tp get the text of selected radiobutton


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);


        // calendar object
        Calendar calendar = Calendar.getInstance();
        btnDatePicker = findViewById(R.id.idbtndatepicker);
        tvpickeddate = findViewById(R.id.idtvpickeddate);

        radiogroup = findViewById(R.id.idradiogroup);
        radiogroup.clearCheck();


        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(SecondActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month+1;
                        String pickeddate = dayOfMonth+ "/" +month+ "/" + year;
                    tvpickeddate.setText(pickeddate);
                    }
                },year, month,day);
                datePickerDialog.show();
            }
        });

        recievedDataFromFirstActivity();




        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selectedId = group.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);

                Toast.makeText(SecondActivity.this,radioButton.getText(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void recievedDataFromFirstActivity() {

        Intent recievingIntent = getIntent();
        name = recievingIntent.getStringExtra(NAME);
        fatherName = recievingIntent.getStringExtra(FATHERNAME);
        uriToString = recievingIntent.getStringExtra(IMAGE);



//        Uri stringToUri = Uri.parse(uriToString);
//        Toast.makeText(this, "stringToUri is: "+stringToUri ,Toast.LENGTH_SHORT).show();
//        ivtest.setImageURI(stringToUri);

    }

}