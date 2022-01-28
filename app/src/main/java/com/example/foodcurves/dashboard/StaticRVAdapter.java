package com.example.foodcurves.dashboard;

import android.content.Context;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodcurves.R;

import java.util.List;
import java.util.zip.Inflater;

public class StaticRVAdapter extends RecyclerView.Adapter<StaticRVAdapter.StaticRVViewHolder> {

    private List<StaticRVModel> list;
    Context context;
    private LinearLayout linearLayoutCheck;

    public StaticRVAdapter(List<StaticRVModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public StaticRVViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.static_rv_item, parent, false);
        context = view.getContext();
        return new StaticRVViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StaticRVViewHolder holder, int position) {
        int foodImage1 = list.get(position).getImage1();
        String foodName1 = list.get(position).getText1();
        int foodImage2 = list.get(position).getImage2();
        String foodName2 = list.get(position).getText2();
        holder.setData(foodName1, foodImage1, foodName2, foodImage2);

        holder.linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(linearLayoutCheck!=null) {
                    linearLayoutCheck.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                linearLayoutCheck = holder.linearLayout1;
                linearLayoutCheck.setBackgroundColor(Color.parseColor("#f8bbd0"));
                //notifyDataSetChanged();
            }
        });
        holder.linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(linearLayoutCheck!=null) {
                    linearLayoutCheck.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                linearLayoutCheck = holder.linearLayout2;
                linearLayoutCheck.setBackgroundColor(Color.parseColor("#f8bbd0"));
                //notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class StaticRVViewHolder extends RecyclerView.ViewHolder {

        ImageView foodImageView1;
        TextView foodNameView1;
        ImageView foodImageView2;
        TextView foodNameView2;
        LinearLayout linearLayout1;
        LinearLayout linearLayout2;
        public StaticRVViewHolder(@NonNull View itemView) {
            super(itemView);

            foodImageView1 = itemView.findViewById(R.id.food_img1);
            foodNameView1 = itemView.findViewById(R.id.food_name1);
            foodImageView2 = itemView.findViewById(R.id.food_img2);
            foodNameView2 = itemView.findViewById(R.id.food_name2);
            linearLayout1 = itemView.findViewById(R.id.linear_layout1);
            linearLayout2 = itemView.findViewById(R.id.linear_layout2);
        }

        public void setData(String foodName1, int foodImage1, String foodName2, int foodImage2) {
            foodImageView1.setImageResource(foodImage1);
            foodNameView1.setText(foodName1);
            foodImageView2.setImageResource(foodImage2);
            foodNameView2.setText(foodName2);
        }
    }
}
