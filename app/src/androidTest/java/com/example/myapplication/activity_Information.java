package com.example.myapplication;
import android.annotation.SuppressLint;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.ColorInt;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.content.Intent;

public class login extends AppCompatActivity{

    private Button login;
    @Override
    protected void onCreate(Bundle sacedInstanceState){
        super.onCreate(sacedInstanceState);
        setContentView(R.layout.Information);

    }

}