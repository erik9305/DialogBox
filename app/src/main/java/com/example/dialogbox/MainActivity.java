package com.example.dialogbox;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements ExampleDialog.ExampleDialogListener {
    private TextView textViewFrom;
    private TextView textViewTo;
    private TextView textViewDate;
    private TextView textViewSeats;
    private TextView textViewTime;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewFrom = (TextView) findViewById(R.id.textview_from);
        textViewTo = (TextView) findViewById(R.id.textview_to);
        textViewDate = (TextView) findViewById(R.id.textview_date);
        textViewSeats = (TextView) findViewById(R.id.textview_seats);
        textViewTime = (TextView) findViewById(R.id.textview_time);
        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openDialog();
            }
        });
    }

    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }

    @Override
    public void applyTexts(String from, String to, String date, String seats, String time) {
        textViewFrom.setText(from);
        textViewTo.setText(to);
        textViewDate.setText(date);
        textViewSeats.setText(seats);
        textViewTime.setText(time);

    }
}