package com.example.admin.w3d3sqlrecyclerview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class AnimalRecyclerViewActivity extends AppCompatActivity {

    RecyclerView rvAnimal;
    RecyclerView.LayoutManager layoutManager;
    RecyclerView.ItemAnimator itemAnimator;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animal_recycler_view);

        final DatabaseHelper db = new DatabaseHelper(getBaseContext());
        final ArrayList<Animal> animals = db.getAnimals();

        rvAnimal = (RecyclerView) findViewById(R.id.rvAnimalList);

        final RecyclerViewAdapter adapter = new RecyclerViewAdapter(animals, this);
        rvAnimal.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(this);
        itemAnimator = new DefaultItemAnimator();
        rvAnimal.setLayoutManager(layoutManager);
        rvAnimal.setItemAnimator(itemAnimator);

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT ) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                Toast.makeText(context, "on Move", Toast.LENGTH_SHORT).show();
                Log.d("TAG", "onMove: ");
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                Toast.makeText(context, "Deleted! ", Toast.LENGTH_SHORT).show();
                //Remove swiped item from list and notify the RecyclerView
                int position = viewHolder.getAdapterPosition();
                db.deleteAnimal(animals.get(position).getId());
                animals.remove(position);
                adapter.notifyDataSetChanged();

            }

        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(rvAnimal);


    }
}
