package com.example.foodcurves.dashboard;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodcurves.DRVInterface.LoadMore;
import com.example.foodcurves.R;

import java.util.ArrayList;
import java.util.UUID;

public class DashBoardFragment extends Fragment {

    RecyclerView recyclerViewTop1;
    RecyclerView recyclerViewTop2;
    StaticRVAdapter staticRVAdapter;
    RecyclerView recyclerViewBottom;
    DynamicRVAdapter dynamicRVAdapter;

    ArrayList<DynamicRVModel> items;
    ArrayList<StaticRVModel> item;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.dashboard_fragment,container, false);

        //WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        recyclerViewTop1 = root.findViewById(R.id.recycler_view_top1);
        recyclerViewTop2 = root.findViewById(R.id.recycler_view_top2);
        recyclerViewBottom = root.findViewById(R.id.recycler_view_bottom);

        item = new ArrayList<>();
        item.add(new StaticRVModel(R.drawable.pizza_img, "Pizza", R.drawable.pizza_img, "Pizza"));
        item.add(new StaticRVModel(R.drawable.fries, "Fries", R.drawable.fries, "Fries"));
        item.add(new StaticRVModel(R.drawable.fries_, "French Fries", R.drawable.fries_, "French Fries"));
        item.add(new StaticRVModel(R.drawable.chicken_nugget, "Nuggets", R.drawable.chicken_nugget, "Nuggets"));
        item.add(new StaticRVModel(R.drawable.egg_roll, "Egg Roll", R.drawable.egg_roll, "Egg Roll"));
        item.add(new StaticRVModel(R.drawable.hamburger_fries, "Burgers", R.drawable.hamburger_fries, "Burgers"));
        item.add(new StaticRVModel(R.drawable.chocolate, "Chocolates", R.drawable.chocolate, "Chocolates"));

        staticRVAdapter = new StaticRVAdapter(item);

        recyclerViewTop1.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewTop1.setAdapter(staticRVAdapter);

        recyclerViewTop2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewTop2.setAdapter(staticRVAdapter);

        items = new ArrayList<>();
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

        recyclerViewBottom.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false));
        dynamicRVAdapter = new DynamicRVAdapter(recyclerViewBottom, getActivity(), items);
        recyclerViewBottom.setAdapter(dynamicRVAdapter);

        dynamicRVAdapter.setLoadMore(new LoadMore() {
            @Override
            public void onLoadMore() {
                if(items.size()<=50){
                    items.add(null);
                    dynamicRVAdapter.notifyItemInserted(items.size()-1);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            items.remove(items.size()-1);
                            dynamicRVAdapter.notifyItemRemoved(items.size()-1);
                            generateData();
                            dynamicRVAdapter.notifyDataSetChanged();
                            dynamicRVAdapter.setLoaded();
                        }
                    }, 4000);
                }
                else {
                    Toast.makeText(getActivity(), "Data completed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return root;
    }

    public void generateData(){
        for(int i=0 ; i<10 ; i++){
            String name = UUID.randomUUID().toString();
            items.add(new DynamicRVModel(name.substring(0,8)));
        }
    }
}
