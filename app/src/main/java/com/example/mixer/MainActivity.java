package com.example.mixer;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Switch btnswicth;
    RadioButton r1, r2, r3, r4;
    CheckBox Male, Female;
ImageView image;
    Boolean isckeck3 = true, isckeck4 = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        btnswicth = findViewById(R.id.btnswicth);
        image = findViewById(R.id.image);
        r1 = findViewById(R.id.item1);
        r2 = findViewById(R.id.item2);
        r3 = findViewById(R.id.item3);
        r4 = findViewById(R.id.item4);
        Male = findViewById(R.id.Male);
        Female = findViewById(R.id.Female);

        String uriString = getIntent().getStringExtra("image");

        Uri imagUri = Uri.parse(uriString);

        image.setImageURI(imagUri);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnswicth.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {
                    btnswicth.setThumbDrawable(getDrawable(R.drawable.nightmode));
                } else {
                    btnswicth.setThumbDrawable(getDrawable(R.drawable.brightness));
                }
                Log.d("++++++", "onCheckedChanged: " + isChecked);
            }
        });

        r1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Log.d("++++++", "onCheckedChanged: Button 1 " + isChecked);
            }
        });
        r2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Log.d("++++++", "onCheckedChanged: Button 2 " + isChecked);
            }
        });
        r3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isckeck3 = !isckeck3;
                r3.setChecked(!isckeck3);
            }
        });
        r4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isckeck4 = !isckeck4;
                r4.setChecked(!isckeck4);
            }
        });

        Male.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Log.d("++++++", "onCheckedChanged: maleclick " + isChecked);
            }
        });
        Female.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                Log.d("++++++", "onCheckedChanged: femaleclick " + isChecked);
            }
        });
    }
}