package com.example.climaact;

import android.os.Bundle;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class HomeActivity extends AppCompatActivity {

    private TextView tvUserName;
    private ViewPager2 viewPager;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();

        // Find views by their IDs
        tvUserName = findViewById(R.id.tvUserName);
        viewPager = findViewById(R.id.viewPager);

        // Set up the user's name
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            tvUserName.setText(currentUser.getDisplayName());
        }

        // Set up the ViewPager with an adapter
        viewPager.setAdapter(new CarouselAdapter());

        // Set up the page indicators (if needed)
        // This can be achieved by using a library or custom implementation
    }
}
