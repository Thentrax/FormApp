package com.example.form;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

public class MainActivity extends Activity {
    private long selectedDate;

    @Override
    protected void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setContentView(R.layout.form);
    }

    @Override
    protected void onStart() {

        super.onStart();
        Button button = findViewById(R.id.calculateButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText value = findViewById(R.id.value);
                String valueString = value.getText().toString();
                Float startValue = Float.parseFloat(valueString);

                DatePicker datePicker = findViewById(R.id.datePicker);

                int day = datePicker.getDayOfMonth();
                int month = datePicker.getMonth();
                int year = datePicker.getYear();

                String selectedDate = day + "/" + (month + 1) + "/" + year;

                EditText cdiPercent = findViewById(R.id.cdiPercent);
                String percentString = cdiPercent.getText().toString();


                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                intent.putExtra("startValue", startValue);
                intent.putExtra("calendarValue", selectedDate);
                intent.putExtra("cdiPercent", percentString);


                startActivity(intent);
            }
        });
    }
}
