package com.example.aps;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Feedback extends AppCompatActivity {
    EditText name, email, message;
    Button btnview, btnsend;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        db = new DatabaseHelper(this);
        name = findViewById(R.id.FD_name);
        email = findViewById(R.id.FD_email);
        message = findViewById(R.id.FD_message);
        btnsend = findViewById(R.id.btnFD);
        btnview = findViewById(R.id.btnViewFeedback);

        btnsend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnview.setEnabled(true);
                if (name.getText().toString().equals("") || email.getText().toString().equals("") || message.getText().toString().equals("")) {
                    Toast.makeText(getApplicationContext(), "All Fields must be filled!", Toast.LENGTH_LONG).show();
                }else {
                    Boolean insert = db.insert(name.getText().toString(), email.getText().toString(), message.getText().toString());
                    if (insert == true) {
                        Toast.makeText(getApplicationContext(), "Sent Feedback Successfully", Toast.LENGTH_SHORT).show();
                        btnsend.setEnabled(true);
                    }else{
                        Toast.makeText(getApplicationContext(), "Cannot Sent Feedback", Toast.LENGTH_SHORT).show();
                    }
                }
                btnview.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        new AlertDialog.Builder(Feedback.this)
                                .setTitle("Your Feedback:")
                                .setMessage("Full Name :- " + name.getText().toString() + "\n\nEmail Address :- " + email.getText().toString() + "\n\nMessage :- " + message.getText().toString())
                                .show();
                    }
                });
            }
        });
    }
}