package com.example.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

public class splashActivity extends AppCompatActivity {


    private Handler handler = new Handler();
    private Runnable runnableToMainActivity = new Runnable() {
        @Override
        public void run() {
            toMainActivity();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        handler.postDelayed(runnableToMainActivity,3000);
    }
    /**
     * 跳转到主界面
     */
    private void toMainActivity() {
        Log.d("SplashActivity","toMainActivity()");
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //防止内存泄漏
        handler.removeCallbacks(runnableToMainActivity);
    }
}