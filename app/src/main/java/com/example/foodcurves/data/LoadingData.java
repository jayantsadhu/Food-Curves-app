package com.example.foodcurves.data;

import com.example.foodcurves.R;
import com.example.foodcurves.brands.BrandsRVModel;
import com.example.foodcurves.dashboard.DynamicRVModel;
import com.example.foodcurves.dashboard.StaticRVModel;

import java.util.List;

public class LoadingData {

    public static void putStaticsData(List<StaticRVModel> item){
        item.add(new StaticRVModel(R.drawable.biryani, "Biryani", R.drawable.pizza_img, "Pizza"));
        item.add(new StaticRVModel(R.drawable.chineese, "Chinese", R.drawable.north_indian, "North Indian"));
        item.add(new StaticRVModel(R.drawable.chocolate, "Chocolates", R.drawable.fries_, "French Fries"));
        item.add(new StaticRVModel(R.drawable.kabab, "Kabab", R.drawable.chicken_nugget, "Nuggets"));
        item.add(new StaticRVModel(R.drawable.south_indian, "South Indian", R.drawable.egg_roll, "Egg Roll"));
        item.add(new StaticRVModel(R.drawable.pizza, "Pizza", R.drawable.hamburger_fries, "Burgers"));
        item.add(new StaticRVModel(R.drawable.burger, "Burger", R.drawable.chocolate, "Chocolates"));
    }

    public static void putDynamicData(List<DynamicRVModel> items){
        items.add(new DynamicRVModel("Burger"));
        items.add(new DynamicRVModel("Fries"));
        items.add(new DynamicRVModel("Chicken"));
        items.add(new DynamicRVModel("Egg Roll"));
        items.add(new DynamicRVModel("Tanduri"));
        items.add(new DynamicRVModel("Lachha"));
        items.add(new DynamicRVModel("Dhosa"));
        items.add(new DynamicRVModel("Idli"));
        items.add(new DynamicRVModel("Chowmin"));
        items.add(new DynamicRVModel("Pasta"));
        items.add(new DynamicRVModel("Biryani"));
        items.add(new DynamicRVModel("Egg Boil"));
        items.add(new DynamicRVModel("Omlete"));
        items.add(new DynamicRVModel("Paratha"));
        items.add(new DynamicRVModel("Rice"));
        items.add(new DynamicRVModel("Chicken Chowmin"));
        items.add(new DynamicRVModel("Kulfi"));
        items.add(new DynamicRVModel("Momo"));
        items.add(new DynamicRVModel("Luchi"));
    }

    public static void putBrandsData(List<BrandsRVModel> list){
        int off = 45;
        int upto = 125;
        list.add(new BrandsRVModel(R.drawable.kfc_logo, "KFC", off, upto, R.drawable.dominos_logo, "Dominose", off, upto));
        list.add(new BrandsRVModel(R.drawable.wow_momo_logo, "Wow! momo", off, upto, R.drawable.subway, "Subway", off, upto));
        list.add(new BrandsRVModel(R.drawable.pizza_hut, "Pizza Hut", off, upto, R.drawable.mcdonalds, "Mcdonalds", off, upto));
        list.add(new BrandsRVModel(R.drawable.the_biryani_inc, "The Biryani Inc.", off, upto, R.drawable.tasty_bites, "Tasty Bites", off, upto));
        list.add(new BrandsRVModel(R.drawable.kfc_logo, "KFC", off, upto, R.drawable.dominos_logo, "Dominose", off, upto));
        list.add(new BrandsRVModel(R.drawable.wow_momo_logo, "Wow! momo", off, upto, R.drawable.subway, "Subway", off, upto));
        list.add(new BrandsRVModel(R.drawable.pizza_hut, "Pizza Hut", off, upto, R.drawable.mcdonalds, "Mcdonalds", off, upto));
        list.add(new BrandsRVModel(R.drawable.the_biryani_inc, "The Biryani Inc.", off, upto, R.drawable.tasty_bites, "Tasty Bites", off, upto));
    }
}
