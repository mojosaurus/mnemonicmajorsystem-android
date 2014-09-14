package com.demimojo.majorsystem.quiz.activity;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.demimojo.majorsystem.quiz.R;
import com.demimojo.majorsystem.quiz.utils.Logger;

import java.util.Random;

public class LearnImages extends ActionBarActivity {

    private int max = 99;
    private int min = 1;
    private final String LogComponent = "LearnImages";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_learn_numbers);

        final Random rand = new Random();

        int randomNum = rand.nextInt((max - min) + 1) + min;
        String randomStr = String.format("%02d", randomNum);

        int imgId = getResources().getIdentifier("drawable/img_"+randomStr, "drawable", getPackageName());
        ImageView imgView = (ImageView)findViewById(R.id.img_activity_learn_numbers);
        imgView.setBackgroundResource(imgId);
        imgView.setVisibility(View.VISIBLE);

        TextView numberView = (TextView)findViewById(R.id.learn_number_text);
        numberView.setText(randomStr);
        numberView.setVisibility(View.INVISIBLE);

        final RelativeLayout layout = (RelativeLayout)findViewById(R.id.learn_numbers_layout);
        layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView numberView = (TextView)findViewById(R.id.learn_number_text);
                if (numberView.getVisibility() == View.INVISIBLE) {
                    // We need to make the text visible.
                    numberView.setVisibility(View.VISIBLE);
                } else {
                    // We need to make the number invisible, and generate a new image.
                    numberView.setVisibility(View.INVISIBLE);

                    int randomNum = rand.nextInt((max - min) + 1) + min;
                    String randomStr = String.format("%02d", randomNum);

                    numberView.setText(randomStr);
                    numberView.setVisibility(View.INVISIBLE);

                    int imgId = getResources().getIdentifier("drawable/img_"+randomStr, "drawable", getPackageName());
                    ImageView imgView = (ImageView)findViewById(R.id.img_activity_learn_numbers);
                    imgView.setBackgroundResource(imgId);
                    imgView.setVisibility(View.VISIBLE);
                }
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.learn_images, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
