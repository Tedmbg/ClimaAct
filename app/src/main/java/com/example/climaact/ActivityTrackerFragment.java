package com.example.climaact;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

public class ActivityTrackerFragment extends Fragment {

    private TextView stepsTextView;
    private TextView modeOfTransportTextView;
    private CalendarView calendarView;

    public ActivityTrackerFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_activity_tracker, container, false);

        stepsTextView = view.findViewById(R.id.stepsTextView);
        modeOfTransportTextView = view.findViewById(R.id.modeOfTransportTextView);
        calendarView = view.findViewById(R.id.calendarView);

        // Initialize with some values
        stepsTextView.setText("Steps: 0");
        modeOfTransportTextView.setText("Mode of Transport: Walking");

        calendarView.setOnDateChangeListener((view1, year, month, dayOfMonth) -> {
            // Handle date selection and update UI
        });

        return view;
    }
}
