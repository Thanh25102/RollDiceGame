package com.example.constraintlayouttutoriall;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.ImageView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView dice1 = findViewById(R.id.dice1);
        ImageView dice2 = findViewById(R.id.dice2);

        List<Integer> diceImg = Arrays.asList(R.drawable.diceone,R.drawable.dicetwo,
                R.drawable.dicethree,R.drawable.dicefour,R.drawable.dicefive,R.drawable.dicesix);

        final MediaPlayer mp = MediaPlayer.create(this,R.raw.dicesound);

        findViewById(R.id.btnRoll).setOnClickListener(v->{
            Random rndObj = new Random();
            YoYo.with(Techniques.Shake)
                    .duration(500)
                    .repeat(4)
                    .playOn(dice1);
            YoYo.with(Techniques.Shake)
                    .duration(500)
                    .repeat(4)
                    .playOn(dice2);
            mp.start();
            dice1.setImageResource(diceImg.get(rndObj.nextInt(5)));
            dice2.setImageResource(diceImg.get(rndObj.nextInt(5)));
        });
    }
}