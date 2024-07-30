package com.example.climaact;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class EventDetailActivity extends AppCompatActivity {

    private TextView textViewEventName, textViewEventDetails, textViewEventDate;
    private Button plantTreeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);

        textViewEventName = findViewById(R.id.textViewEventName);
        textViewEventDetails = findViewById(R.id.textViewEventDetails);
        textViewEventDate = findViewById(R.id.textViewEventDate);
        plantTreeButton = findViewById(R.id.plantTreeButton);

        // Get event details from intent and set to TextViews
        // Example:
        // String eventName = getIntent().getStringExtra("event_name");
        // textViewEventName.setText(eventName);

        plantTreeButton.setOnClickListener(v -> {
            // Handle plant a tree logic
        });
    }
}
