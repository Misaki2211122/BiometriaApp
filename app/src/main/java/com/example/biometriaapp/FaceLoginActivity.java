package com.example.biometriaapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.hardware.Camera;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.OrientationEventListener;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.biometriaapp.models.faceLogin.CameraErrorCallback;
import com.example.biometriaapp.models.faceLogin.FaceOverlayView;
import com.example.biometriaapp.models.faceLogin.Util;
import com.example.biometriaapp.services.clients.bsclient.api.AndroidApi;

import android.hardware.Camera.Face;
import android.view.ViewGroup.LayoutParams;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FaceLoginActivity  extends AppCompatActivity {

    private FingerLoginActivity.FingerprintHelper mFingerprintHelper;
    private Intent intent;
    private ExecutorService executor;
    private AndroidApi api;
    private String DeviceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face_login);
        DeviceId = "1111";
        intent = new Intent(this, SuccessLoginActivity.class);
        api = new AndroidApi();
        executor= Executors.newSingleThreadExecutor();
    }
}
