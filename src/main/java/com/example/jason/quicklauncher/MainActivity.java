package com.example.jason.quicklauncher;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
//This is the first session to create an actual app "Hello World"
//https://www.youtube.com/watch?v=6ow3L39Wxmg&t=1459s

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* Attempts to launch an activity within our own app */
        Button secondActivityBtn = (Button)findViewById(R.id.SecondActivityBtn);
        secondActivityBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent startIntent = new Intent(getApplicationContext(),SecondActivity.class);
                //show how to pass info to another screen
                startIntent.putExtra("jason.AndroidStudioProjects.QuickLauncher.SOMETHING","HELLO WORLD!!!");
                startActivity(startIntent);
            }
        });

        /* Attempt to launch an activity outside of our app */
        Button googleBtn = (Button)findViewById(R.id.googleBtn);
        googleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String google = "https://edmondscooking.co.nz/recipes/sweet-pastries/fruit-squares/";
                Uri webaddress = Uri.parse(google);

                Intent gotoGoogle = new Intent(Intent.ACTION_VIEW, webaddress);
                if (gotoGoogle.resolveActivity(getPackageManager())!= null){
                    startActivity(gotoGoogle);
                }
            }
        });

    }
}
