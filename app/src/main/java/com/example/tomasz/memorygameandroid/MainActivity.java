package com.example.tomasz.memorygameandroid;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.Image;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    static final int REQUEST_IMAGE_CAPTURE = 1;
    Button takePhotos, startGame;
    ImageView myImg1, myImg2, myImg3, myImg4, myImg5, myImg6;
    public int counter=0;
    ArrayList<ImageView> arr;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        takePhotos=(Button)findViewById(R.id.button);
        startGame=(Button)findViewById(R.id.button2) ;
        startGame.setEnabled(false);
        myImg1=(ImageView)findViewById(R.id.imageView);
        myImg2=(ImageView)findViewById(R.id.imageView2);
        myImg3=(ImageView)findViewById(R.id.imageView3);
        myImg4=(ImageView)findViewById(R.id.imageView5);
        myImg5=(ImageView)findViewById(R.id.imageView6);
        myImg6=(ImageView)findViewById(R.id.imageView7);
/*
        myImg1.setTag(1,"tag1");
        myImg2.setTag(2,"tag2");
        myImg3.setTag(1,"tag1");
        myImg4.setTag(3,"tag3");
        myImg5.setTag(3,"tag1");
        myImg6.setTag(2,"tag2");
*/
        arr = new ArrayList<>();
        arr.add(myImg1);
        arr.add(myImg2);
        arr.add(myImg3);
        arr.add(myImg4);
        arr.add(myImg5);
        arr.add(myImg6);



    }

    public void dispatchTakePictureIntent(View view) {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            arr.get(counter).setImageBitmap(imageBitmap);
            counter++;
            if(counter>=6){
                takePhotos.setEnabled(false);
                startGame.setEnabled(true);

            }
        }
    }

    public void makeVis(View view) {


    }


}
