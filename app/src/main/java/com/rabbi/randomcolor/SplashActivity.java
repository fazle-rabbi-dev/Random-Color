package com.rabbi.randomcolor;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

public class SplashActivity extends Activity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        
       new Thread(new Runnable(){

             @Override
             public void run() {
                try {
                   Thread.sleep(700);
                   startActivity(new Intent(getApplicationContext(),MainActivity.class));
                   overridePendingTransition(0,0);
                } catch (InterruptedException e) {
                   e.printStackTrace();
                }
             }
                        
        }).start();
        
    }
    
}
