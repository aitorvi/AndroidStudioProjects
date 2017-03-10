package com.example.aitor.lab51;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClickInstrumento(View v) {
        Animation animacion = AnimationUtils.loadAnimation(this, R.anim.girar);
        v.startAnimation(animacion);
        MediaPlayer so = null;
        switch (v.getId()) {
            case R.id.imageView1:
                so = MediaPlayer.create(this, R.raw.timple);
                break;
            case R.id.imageView2:
                so = MediaPlayer.create(this, R.raw.piano);
                break;
            case R.id.imageView3:
                so = MediaPlayer.create(this, R.raw.guitarra);
                break;
            case R.id.imageView4:
                so = MediaPlayer.create(this, R.raw.trompeta);
                break;
            case R.id.imageView5:
                so = MediaPlayer.create(this, R.raw.bateria);
                break;
            case R.id.imageView6:
                so = MediaPlayer.create(this, R.raw.harmonica);
                break;
        }

        so.start();

        // Alliberar el MediaPlayer quan acabi de reproduir la pista d'àudio
        so.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

            @Override
            public void onCompletion(MediaPlayer mp) {
                mp.release();
            }
        });
    }
}





