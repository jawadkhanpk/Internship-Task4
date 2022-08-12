package com.example.internshiptask4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


////////////////////////////recieved data from MainActivity /////////////////////////////////
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import static com.example.internshiptask4.MainActivity.NAME;
import static com.example.internshiptask4.MainActivity.FATHERNAME;
import static com.example.internshiptask4.MainActivity.IMAGE;
///////////////////////////////////////////////////////////////////////////////////////////////


public class SecondActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    private String name;            // strings to hold data that is recieved from mainActivity
    private String fatherName;      // strings to hold data that is recieved from mainActivity
    private String uriToString;     // strings to hold data that is recieved from mainActivity

/////////////////////////////////////////Date Picker/////////////////////////////////////////////////////////////
    Button btnDatePicker;
    int year;
    int month;
    int day;
    TextView tvpickeddate;
/////////////////////////////////////////Date Picker///////////////////////////////////////////////////////////////////////

///////////////////////////////////////////////////////////////////////////////////
    RadioGroup radiogroup;
    RadioButton radioButton;
/////////////////////////////////////////////////////////////////////////////////////
    SeekBar seekBarAge;
    TextView tvAgeDisplay;
/////////////////////////////////////////////////////////////////////////////////////

    Spinner spinnercities;
    String cities;

///////////////////////////////////////////////////////////////////////////////////////

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

        seekBarAge = findViewById(R.id.idseekbarage);
        seekBarAge.setMax(60);

        tvAgeDisplay = findViewById(R.id.textView7);

        spinnercities = findViewById(R.id.idSpinnerCity);


        btnDatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                day = calendar.get(Calendar.DAY_OF_MONTH);
                DatePickerDialog datePickerDialog = new DatePickerDialog(SecondActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        month = month + 1;
                        String pickeddate = dayOfMonth + "/" + month + "/" + year;
                        tvpickeddate.setText(pickeddate);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });

        recievedDataFromFirstActivity();


        radiogroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                int selectedId = group.getCheckedRadioButtonId();
                radioButton = (RadioButton) findViewById(selectedId);
                Toast.makeText(SecondActivity.this, radioButton.getText(), Toast.LENGTH_SHORT).show();

            }
        });

        seekBarAge.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvAgeDisplay.setText("Age is: "+String.valueOf(progress));

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this,R.array.cities, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnercities.setAdapter(adapter);
        spinnercities.setOnItemSelectedListener(this);

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



    /////////////////////////////////////////////Spinner code to implement onItemSelectedListener////////////////////
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        cities = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(),cities,Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    /////////////////////////////////////////////Spinner code to implement onItemSelectedListener////////////////////
}