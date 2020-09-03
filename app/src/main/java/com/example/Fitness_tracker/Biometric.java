package com.example.Fitness_tracker;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.biometric.BiometricManager;
import androidx.biometric.BiometricPrompt;
import androidx.core.content.ContextCompat;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.Executor;

public class Biometric extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biometric);

        TextView txtmsg = findViewById(R.id.txtMsg);
        Button loginButton = findViewById(R.id.loginButton);
        final BiometricManager biometricManager = BiometricManager.from(this);
        //Check if we are able to use the biometric Sensors or not.
        switch(biometricManager.canAuthenticate()){
            case BiometricManager.BIOMETRIC_SUCCESS:
                txtmsg.setText("You may use FingerPrint Sensor to login!");
                txtmsg.setTextColor(Color.parseColor("#Fafafa"));
                break;
                case BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE:
                    txtmsg.setText("Device don't have FingerPrint Sensor!");
                    break;
                    case BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE:
                        txtmsg.setText("Biometric sensors are currently unavailable");
                        loginButton.setVisibility(View.GONE);
                        break;
                        case BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED:
                            txtmsg.setText("Your device doesn't have any fingerprint saved. PLease check your security settings");
                            loginButton.setVisibility(View.GONE);
                            break;
        }
        Executor executor = ContextCompat.getMainExecutor(this);
        //Create a Biometric Prompt Callback
        //This will give us result of the authentication, to see if we can login or not.

        final BiometricPrompt biometricPrompt = new BiometricPrompt(Biometric.this, executor, new BiometricPrompt.AuthenticationCallback() {
            @Override
            public void onAuthenticationError(int errorCode, @NonNull CharSequence errString) {
                super.onAuthenticationError(errorCode, errString);
            }

            @Override
            public void onAuthenticationSucceeded(@NonNull BiometricPrompt.AuthenticationResult result) {
                super.onAuthenticationSucceeded(result);
                Toast.makeText(getApplicationContext(),"Login Success!",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAuthenticationFailed() {
                super.onAuthenticationFailed();
            }
        });
        //create Biometric Dialogue
        final BiometricPrompt.PromptInfo promptInfo = new BiometricPrompt.PromptInfo.Builder()
                .setTitle("Login")
                .setDescription("Use your fingerprint to login to your app")
                .setNegativeButtonText("Cancel")
                .build();
        //call dialogue once user press login button
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                biometricPrompt.authenticate(promptInfo);
                Intent intent = new Intent(Biometric.this,SelectionActivity.class);
                startActivity(intent);
            }
        });
    }
}