package widaas.cidaas.rajanarayanan.myapplication;

import android.content.Intent;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import widaas.cidaas.rajanarayanan.myandroidlibrary.AndroidCidaas;
import widaas.cidaas.rajanarayanan.myandroidlibrary.Biometric.BiometricCallback;
import widaas.cidaas.rajanarayanan.myandroidlibrary.Biometric.BiometricManager;
import widaas.cidaas.rajanarayanan.mylibrary.SampleTesting;

public class MainActivity extends AppCompatActivity {
    AndroidCidaas androidCidaas;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SampleTesting sampleTesting=new SampleTesting();
        androidCidaas=new AndroidCidaas(this);

        //Toast.makeText(this, ""+ sampleTesting.getName(), Toast.LENGTH_SHORT).show();

        //Toast.makeText(this, ""+androidCidaas.getGetClass(), Toast.LENGTH_SHORT).show();
    }


    public void buttonClick(View view)
    {

       //  androidCidaas.getLoginDetails();

        new BiometricManager.BiometricBuilder(MainActivity.this)
                .setTitle(getString(R.string.biometric_title))
                .setSubtitle(getString(R.string.biometric_subtitle))
                .setDescription(getString(R.string.biometric_description))
                .setNegativeButtonText(getString(R.string.biometric_negative_button_text))
                .build()
                .authenticate(new BiometricCallback() {
                    @Override
                    public void onSdkVersionNotSupported() {
                        Toast.makeText(MainActivity.this, "SDK not supported", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onBiometricAuthenticationNotSupported() {
                        Toast.makeText(MainActivity.this, "onBiometricAuthenticationNotSupported", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onBiometricAuthenticationNotAvailable() {
                        Toast.makeText(MainActivity.this, "onBiometricAuthenticationNotAvailable", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onBiometricAuthenticationPermissionNotGranted() {
                        Toast.makeText(MainActivity.this, "onBiometricAuthenticationPermissionNotGranted", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onBiometricAuthenticationInternalError(String error) {
                        Toast.makeText(MainActivity.this, "onBiometricAuthenticationInternalError", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAuthenticationFailed() {
                        Toast.makeText(MainActivity.this, "onAuthenticationFailed", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAuthenticationCancelled() {
                        Toast.makeText(MainActivity.this, "onAuthenticationCancelled", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAuthenticationSuccessful() {
                        Toast.makeText(MainActivity.this, "onAuthenticationSuccessful", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAuthenticationHelp(int helpCode, CharSequence helpString) {
                        Toast.makeText(MainActivity.this, "onAuthenticationHelp", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onAuthenticationError(int errorCode, CharSequence errString) {
                        Toast.makeText(MainActivity.this, "onAuthenticationError", Toast.LENGTH_SHORT).show();
                    }
                });
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        androidCidaas.onActivityResult(requestCode,resultCode,data);
    }
}
