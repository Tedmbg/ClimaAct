package com.example.climaact;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
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
    private Handler sliderHandler = new Handler(Looper.getMainLooper());

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

        // Auto-scroll setup
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                sliderHandler.removeCallbacks(sliderRunnable);
                sliderHandler.postDelayed(sliderRunnable, 3000); // Auto scroll delay
            }
        });
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            int currentItem = viewPager.getCurrentItem();
            int totalItems = viewPager.getAdapter().getItemCount();
            if (currentItem < totalItems - 1) {
                viewPager.setCurrentItem(currentItem + 1);
            } else {
                viewPager.setCurrentItem(0);
            }
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        sliderHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sliderHandler.postDelayed(sliderRunnable, 3000); // Auto scroll delay
    }
}
