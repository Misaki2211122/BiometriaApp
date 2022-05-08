package com.example.biometriaapp;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.CancellationSignal;
import android.preference.PreferenceManager;
import android.widget.Toast;
import com.example.biometriaapp.services.clients.bsclient.Configuration;
import com.example.biometriaapp.services.clients.bsclient.api.AndroidApi;
import com.example.biometriaapp.services.clients.bsclient.model.DeviceIdAuthorizeRequest;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

public class FingerLoginActivity  extends AppCompatActivity {


    private SharedPreferences mPreferences;
    private FingerprintHelper mFingerprintHelper;
    private Intent intent;
    private ExecutorService executor;
    private AndroidApi api;
    private String DeviceId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finger_login);
        DeviceId = "1488";
        intent = new Intent(this, SuccessLoginActivity.class);
        mPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        api = new AndroidApi();

    }

    @Override
    protected void onResume() {
        super.onResume();
        prepareSensor();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mFingerprintHelper != null) {
            mFingerprintHelper.cancel();
        }
    }

    private void prepareSensor() {
        mFingerprintHelper = new FingerprintHelper(this);
        mFingerprintHelper.startAuth();
    }


    public class FingerprintHelper extends FingerprintManagerCompat.AuthenticationCallback {
        private Context mContext;
        private CancellationSignal mCancellationSignal;

        FingerprintHelper(Context context) {
            mContext = context;
        }

        void startAuth() {
            FingerprintManagerCompat manager = FingerprintManagerCompat.from(mContext);
            manager.authenticate(null, 0, null, this, null);
        }

        void cancel() {
            if (mCancellationSignal != null) {
                mCancellationSignal.cancel();
            }
        }

        @Override
        public void onAuthenticationError(int errMsgId, CharSequence errString) {
            Toast.makeText(mContext, errString, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAuthenticationHelp(int helpMsgId, CharSequence helpString) {
            Toast.makeText(mContext, helpString, Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAuthenticationSucceeded(FingerprintManagerCompat.AuthenticationResult result) {

                Future<DeviceIdAuthorizeRequest> futureRes = executor.submit(() -> {
                    return api.androidDeviceIdAuthorizePost(DeviceId);
                });

            /*try {
                DeviceIdAuthorizeRequest res = futureRes.get();
                if (res.getDeviceId() == DeviceId){
                    Toast.makeText(mContext, "Вы успешно авторизовались", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }
                else {
                    Toast.makeText(mContext, "Ошибка авторизации попробуйте снова", Toast.LENGTH_SHORT).show();
                }
            } catch (ExecutionException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*/
            Toast.makeText(mContext, "Ошибка авторизации попробуйте снова", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onAuthenticationFailed() {
            Toast.makeText(mContext, "Ошибка авторизации попробуйте снова", Toast.LENGTH_SHORT).show();
        }
    }
}
