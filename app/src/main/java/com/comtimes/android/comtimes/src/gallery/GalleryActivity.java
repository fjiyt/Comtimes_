package com.comtimes.android.comtimes.src.gallery;

import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.comtimes.android.comtimes.R;

public class GalleryActivity extends AppCompatActivity {
    private int[] imageIDs = new int[] {
            R.drawable.image1,
            R.drawable.image2,
            R.drawable.image3,
            R.drawable.image4,
            R.drawable.image5,
            R.drawable.image6,
            R.drawable.image7,
            R.drawable.image8,
            R.drawable.image9,
            R.drawable.image10
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        GridView gridViewImages= findViewById(R.id.gridViewImages);
        ImageGridAdapter imageGridAdapter=new ImageGridAdapter(this, imageIDs);
        gridViewImages.setAdapter(imageGridAdapter);
    }
}

