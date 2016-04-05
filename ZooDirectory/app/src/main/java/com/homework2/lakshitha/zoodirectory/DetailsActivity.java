package com.homework2.lakshitha.zoodirectory;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.content.Intent;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class DetailsActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        Intent i = getIntent();
        Animal animal = (Animal)i.getSerializableExtra("animal");

        TextView nameTextView = (TextView) findViewById(R.id.name_details);
        nameTextView.setText(animal.getName());

        TextView scientificNameTextView = (TextView) findViewById(R.id.scientific_name_details);
        scientificNameTextView.setText(animal.getScientificName());

        try {
            ImageView imageView = (ImageView) findViewById(R.id.full_size_image);
            InputStream inputStream = getBaseContext().getAssets().open(animal.getFullSizeImageFileName());
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }

        TextView descriptionTextView = (TextView) findViewById(R.id.description_content);
        descriptionTextView.setText(animal.getDescription());

    }

}
