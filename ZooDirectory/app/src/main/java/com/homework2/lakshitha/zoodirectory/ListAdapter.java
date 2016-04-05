package com.homework2.lakshitha.zoodirectory;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ListAdapter extends ArrayAdapter<Animal> {

    private final List<Animal> animals;

    public ListAdapter(Context context, int resource, List<Animal> animals) {
        super(context, resource, animals);
        this.animals = animals;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Animal animal = animals.get(position);

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.list_row, null);

        TextView nameTextView = (TextView) row.findViewById(R.id.row_name);
        nameTextView.setText(animal.getName());

        TextView scientificNameTextView = (TextView) row.findViewById(R.id.row_scientific_name);
        scientificNameTextView.setText(animal.getScientificName());

        try {
            ImageView imageView = (ImageView) row.findViewById(R.id.row_image);
            InputStream inputStream = getContext().getAssets().open(animal.getImageFileName());
            Drawable drawable = Drawable.createFromStream(inputStream, null);
            imageView.setImageDrawable(drawable);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return row;
    }
}



