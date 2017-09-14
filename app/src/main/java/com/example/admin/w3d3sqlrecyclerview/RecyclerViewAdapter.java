package com.example.admin.w3d3sqlrecyclerview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by admin on 9/13/2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    ArrayList<Animal> animals = new ArrayList<>();
    Context context;

    public RecyclerViewAdapter(ArrayList<Animal> animals, Context context) {
        this.animals = animals;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Animal animal = animals.get(position);

        Bitmap tmp = BitmapFactory.decodeResource(context.getResources(), animal.getImg1());
        holder.img1.setImageBitmap(tmp);

        tmp = BitmapFactory.decodeResource(context.getResources(), animal.getImg2());
        holder.img2.setImageBitmap(tmp);

        String info = "NAME: " + animal.getName() + " TYPE: " + animal.getType() +
                "\n" + "AGE: " + animal.getAge() + " WEIGHT " + animal.getWeight();
        holder.tvInfo.setText(info);

    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        private final TextView tvInfo;
        private final ImageView img1;
        private final ImageView img2;
        private final ImageView del;

        public ViewHolder(final View itemView) {
            super(itemView);

            tvInfo = itemView.findViewById(R.id.tvInfo);
            img1 = itemView.findViewById(R.id.ivImg1);
            img2 = itemView.findViewById(R.id.ivImg2);
            del = itemView.findViewById(R.id.ivDel);

            /*itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Bitmap tmp = BitmapFactory.decodeResource(context.getResources(), R.drawable.delete);
                    del.setImageBitmap(tmp);
                }
            });*/

        }
    }


}
