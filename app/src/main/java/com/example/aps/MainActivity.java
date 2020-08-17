package com.example.aps;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;


import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    ImageButton button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        OnClickButtonLister();
        OnClickButtonLister1();
        OnClickButtonLister2();
   }

    public void OnClickButtonLister(){
        button = (ImageButton)findViewById(R.id.img1);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        Intent intent = new Intent(MainActivity.this, Edit_account.class);
                        startActivity(intent);
                    }
                }

);
    }
    public void OnClickButtonLister1(){
        button = (ImageButton)findViewById(R.id.img3);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        Intent intent = new Intent(MainActivity.this, history.class);
                        startActivity(intent);
                    }
                }
        );
    }
    public void OnClickButtonLister2(){
        button = (ImageButton)findViewById(R.id.img4);
        button.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {


                        Intent intent = new Intent(MainActivity.this, Change_Password.class);
                        startActivity(intent);
                    }
                }
        );
    }
}









