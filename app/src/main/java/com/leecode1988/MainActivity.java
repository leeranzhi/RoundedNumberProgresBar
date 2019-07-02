package com.leecode1988;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    private int progress = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initProgress();
    }

    /**
     * 初始化ProgressBar
     */
    private void initProgress() {
        final MyProgress progressBar = findViewById(R.id.progress_bar);
        progressBar.setMax(100);

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (progress <= 100) {
                    try {
                        Thread.sleep(1000);
                        progress++;
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            progressBar.setProgress(progress);
                        }
                    });
                }
            }
        }).start();

    }
}
