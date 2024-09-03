package com.example.form;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);

        float startValue = getIntent().getFloatExtra("startValue", 0.0f);
        TextView valueDisplay = findViewById(R.id.startValue);
        valueDisplay.setText(String.valueOf(startValue));

        long selectedDateInMillis = getIntent().getLongExtra("selected_date", 0);
        long todayDateInMillis = getIntent().getLongExtra("today_date", 0);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
        String selectedDate = sdf.format(new Date(selectedDateInMillis));
        String todayDate = sdf.format(new Date(todayDateInMillis));

        TextView selectedDateTextView = findViewById(R.id.startDateDisplay);
        TextView todayDateTextView = findViewById(R.id.endDateDisplay);
        selectedDateTextView.setText("Data Selecionada: " + selectedDate);
        todayDateTextView.setText("Data de Hoje: " + todayDate);
    }


}