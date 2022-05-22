package com.example.biometriaapp;

import android.os.Bundle;
import android.provider.Settings;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GetDeviceIdActivity extends AppCompatActivity {

    private String android_id = Settings.Secure.ANDROID_ID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getdeviceid);

        int res = android_id.hashCode();

        TextView textView = findViewById(R.id.textView5);
        textView.setText(String.valueOf(res));
    }
}
