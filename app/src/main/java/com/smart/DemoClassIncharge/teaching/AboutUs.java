package com.smart.DemoClassIncharge.teaching;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.smart.DemoClassIncharge.R;

public class AboutUs extends AppCompatActivity {

    TextView tv1,tv2,tv3,tv4,tv5,tv7,tv8,tv9;
    ImageView im1,iv4,iv,iv3,iv1,iv5,iv7;
    View v,v1,v2,v3,v4,v5,v7;

    Typeface tf1,tf2,tf3,tf4,tf5,tf6,tf7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);

//        tv1= (TextView) findViewById(R.id.tv1);
//        tv2= (TextView) findViewById(R.id.tv2);
        tv3= (TextView) findViewById(R.id.tv3);
        tv4= (TextView) findViewById(R.id.tv4);
        tv5= (TextView) findViewById(R.id.tv5);
        tv7= (TextView) findViewById(R.id.tv7);
        tv8= (TextView) findViewById(R.id.tv8);
        tv9= (TextView) findViewById(R.id.tv9);
        v=findViewById(R.id.v);
        v1=findViewById(R.id.v1);
        v2=findViewById(R.id.v2);
        v3=findViewById(R.id.v3);
        v4=findViewById(R.id.v4);
        v5=findViewById(R.id.v5);
        v7=findViewById(R.id.v7);
        im1= (ImageView) findViewById(R.id.im1);
        iv4= (ImageView) findViewById(R.id.iv4);
        iv= (ImageView) findViewById(R.id.iv);
        iv3= (ImageView) findViewById(R.id.iv3);
        iv1= (ImageView) findViewById(R.id.iv1);
        iv5= (ImageView) findViewById(R.id.iv5);
        iv7= (ImageView) findViewById(R.id.iv7);

        tf1=Typeface.createFromAsset(getAssets(),"android_7.ttf");
        tf2=Typeface.createFromAsset(getAssets(),"GrandHotel-Regular.otf");
        tf3=Typeface.createFromAsset(getAssets(),"RECOGNITION.ttf");
        tf4=Typeface.createFromAsset(getAssets(),"future.ttf");
        tf5=Typeface.createFromAsset(getAssets(),"CaviarDreams.ttf");
        tf6=Typeface.createFromAsset(getAssets(),"Caviar_Dreams_Bold.ttf");
        tf7=Typeface.createFromAsset(getAssets(),"CinzelDecorative-Black.otf");


//        tv1.setTypeface(tf1);
//        tv2.setTypeface(tf7);
        tv3.setTypeface(tf6);
        tv4.setTypeface(tf2);
        tv5.setTypeface(tf6);
        tv7.setTypeface(tf6);
        tv8.setTypeface(tf6);
        tv9.setTypeface(tf6);


        try {
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }catch (NullPointerException nu){

            Log.i("Error Activity","Error As a Result Of :"+nu.getMessage());

        }

    }
}
