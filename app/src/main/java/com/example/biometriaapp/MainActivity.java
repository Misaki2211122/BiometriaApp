package com.example.biometriaapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private String android_id = Settings.Secure.ANDROID_ID;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button fingerAuth = (Button)findViewById(R.id.fingerAuth);

        Button faceAuth = (Button)findViewById(R.id.faceAuth);

        Button getDeviceId = (Button)findViewById(R.id.getDeviceId);
    }


    public void onClickFingerAuth(View view) {
        Intent i;
        i = new Intent(this, FingerLoginActivity.class);
        startActivity(i);
    }


    public void onClickFaceAuth(View view) {
        Intent i;
        i = new Intent(this, FaceLoginActivity.class);
        startActivity(i);
    }
    public void onClickGetDeviceId(View view) {
        Intent i;
        i = new Intent(this, GetDeviceIdActivity.class);
        startActivity(i);
    }
}