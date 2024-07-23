package com.example.climaact;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(this); // Ensure Firebase is initialized
        setContentView(R.layout.activity_splash);

        FirebaseAuth mAuth = FirebaseAuth.getInstance();
        Button plantATree = findViewById(R.id.plantATree);

        plantATree.setOnClickListener(v -> navigateToNextActivity(mAuth));
    }

    private void navigateToNextActivity(FirebaseAuth mAuth) {
        FirebaseUser currentUser = mAuth.getCurrentUser();
        if (currentUser != null) {
            // User is signed in, navigate to MainActivity
            startActivity(new Intent(SplashActivity.this, MainActivity.class));
        } else {
            // No user is signed in, navigate to LoginActivity
            startActivity(new Intent(SplashActivity.this, LoginActivity.class));
        }
        finish();
    }
}
