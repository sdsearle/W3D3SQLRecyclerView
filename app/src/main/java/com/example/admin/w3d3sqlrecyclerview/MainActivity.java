package com.example.admin.w3d3sqlrecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.facebook.stetho.Stetho;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Stetho.initializeWithDefaults(this);

        DatabaseHelper db = new DatabaseHelper(this);
        if(db.getAnimals().size() == 0) {
            db.saveAnimal("Shiva", "Tiger", 13, 350, R.drawable.tiger1, R.drawable.tiger2);
            db.saveAnimal("Leo", "Lion", 9, 420, R.drawable.lion1, R.drawable.lion2);
            db.saveAnimal("Free Willy", "Whale", 12, 9000, R.drawable.orca1, R.drawable.orca2);
            db.saveAnimal("Oscar", "Ostrich", 3, 250, R.drawable.ostrich1, R.drawable.ostrich2);
            db.saveAnimal("Grape", "Penguin", 5, 40, R.drawable.penguin1, R.drawable.penguin2);
        }
    }

    public void gotoActivity(View view) {
        switch (view.getId()){
            case R.id.btnAnimalActivity:
                Intent intent = new Intent(this,AnimalRecyclerViewActivity.class);
                startActivity(intent);
                break;
        }
    }
}
