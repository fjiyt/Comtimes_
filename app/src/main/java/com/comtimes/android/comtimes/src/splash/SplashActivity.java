package com.comtimes.android.comtimes.src.splash;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.comtimes.android.comtimes.src.login.LoginActivity;
import com.comtimes.android.comtimes.src.main.MainActivity;
import com.comtimes.android.comtimes.src.register.RegisterActivity;

public class SplashActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try{
            Thread.sleep(1000);
            Intent intent=new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        }
        catch(InterruptedException e){
        e.printStackTrace();
        }
    }
}
