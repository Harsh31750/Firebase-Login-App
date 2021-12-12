package com.example.firebaseloginapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.firebaseloginapp.databinding.ActivityMainBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

   private static final String TAG =  "MainActivity";
    private ActivityMainBinding binding;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());




        // todo create firebase project
        // todo  connect your app with firebase project
        // todo add firebase auth to your app
        // todo enable email and password signin method in firebase console



        firebaseAuth = FirebaseAuth.getInstance();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        String name = user.getDisplayName();
        String email = user.getEmail();

        Log.d(TAG, "onCreate: User name : "+ name);
        binding.name.setText(name);
        binding.email.setText(email);

        binding.logout.setOnClickListener(v -> {
           firebaseAuth.signOut();
           startActivity(new Intent(MainActivity.this,SignInActivity.class));
           finish();
        });

    }
}