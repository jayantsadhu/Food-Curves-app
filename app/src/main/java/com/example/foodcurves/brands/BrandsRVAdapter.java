package com.example.foodcurves.brands;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodcurves.R;


import java.util.List;

public class BrandsRVAdapter extends RecyclerView.Adapter<BrandsRVAdapter.BrandViewHolder> {

    private List<BrandsRVModel> list;
    LinearLayout linearLayoutCheck;

    public BrandsRVAdapter(List<BrandsRVModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public BrandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.brands_rv_item, parent, false);
        return new BrandViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BrandViewHolder holder, int position) {
        int logo1 = list.get(position).getLogo1();
        String brand1 = list.get(position).getBrand1();
        int off1 = list.get(position).getOff1();
        int upto1 = list.get(position).getUpto1();

        int logo2 = list.get(position).getLogo2();
        String brand2 = list.get(position).getBrand2();
        int off2 = list.get(position).getOff2();
        int upto2 = list.get(position).getUpto2();
        holder.setData(logo1, brand1, off1, upto1, logo2, brand2, off2, upto2);

        holder.linearLayout1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linearLayoutCheck != null) {
                    linearLayoutCheck.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                linearLayoutCheck = holder.linearLayout1;
                linearLayoutCheck.setBackgroundColor(Color.parseColor("#ff8a65"));
            }
        });
        holder.linearLayout2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (linearLayoutCheck != null) {
                    linearLayoutCheck.setBackgroundColor(Color.parseColor("#ffffff"));
                }
                linearLayoutCheck = holder.linearLayout2;
                linearLayoutCheck.setBackgroundColor(Color.parseColor("#ff8a65"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class BrandViewHolder extends RecyclerView.ViewHolder {

        LinearLayout linearLayout1;
        ImageView brandImageView1;
        TextView brandNameView1;
        TextView brandOff1;
        TextView offUpto1;

        LinearLayout linearLayout2;
        ImageView brandImageView2;
        TextView brandNameView2;
        TextView brandOff2;
        TextView offUpto2;

        public BrandViewHolder(@NonNull View itemView) {
            super(itemView);

            linearLayout1 = itemView.findViewById(R.id.linear_layout1);
            brandImageView1 = itemView.findViewById(R.id.logo1);
            brandNameView1 = itemView.findViewById(R.id.brand_name1);
            brandOff1 = itemView.findViewById(R.id.off1);
            offUpto1 = itemView.findViewById(R.id.upto1);

            linearLayout2 = itemView.findViewById(R.id.linear_layout2);
            brandImageView2 = itemView.findViewById(R.id.logo2);
            brandNameView2 = itemView.findViewById(R.id.brand_name2);
            brandOff2 = itemView.findViewById(R.id.off2);
            offUpto2 = itemView.findViewById(R.id.upto2);

        }

        public void setData(int logo1, String brand1, int off1, int upto1, int logo2, String brand2, int off2, int upto2) {
            brandImageView1.setImageResource(logo1);
            brandNameView1.setText(brand1);
            brandOff1.setText((String.valueOf(off1)+"% OFF"));
            offUpto1.setText(("UPTO"+String.valueOf(upto1)));

            brandImageView2.setImageResource(logo2);
            brandNameView2.setText(brand2);
            brandOff1.setText((String.valueOf(off2)+"% OFF"));
            offUpto1.setText(("UPTO"+String.valueOf(upto2)));
        }
    }
}
