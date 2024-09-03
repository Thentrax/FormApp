package com.example.form;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
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

                CalendarView calendarView = findViewById(R.id.calendarView);

                calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
                    @Override
                    public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                        Calendar calendar = Calendar.getInstance();
                        calendar.set(year, month, dayOfMonth);
                        selectedDate = calendar.getTimeInMillis();
                    }
                });


                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                long initialDate = Calendar.getInstance().getTimeInMillis();

                intent.putExtra("startValue", startValue);
                intent.putExtra("calendarValue", selectedDate);
                intent.putExtra("initialDate", initialDate);


                startActivity(intent);
            }
        });
    }
}
