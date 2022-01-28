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
import com.example.foodcurves.additional.EndingFragment;
import com.example.foodcurves.brands.BrandsRVAdapter;
import com.example.foodcurves.brands.BrandsRVModel;
import com.example.foodcurves.data.LoadingData;

import java.util.ArrayList;
import java.util.UUID;

public class DashBoardFragment extends Fragment {

    RecyclerView recyclerViewTop1;
    RecyclerView recyclerViewTop2;
    RecyclerView brandRView;
    RecyclerView recyclerViewBottom;

    StaticRVAdapter staticRVAdapter;
    BrandsRVAdapter brandsRVAdapter;
    DynamicRVAdapter dynamicRVAdapter;

    ArrayList<DynamicRVModel> items;
    ArrayList<StaticRVModel> item;
    ArrayList<BrandsRVModel> brands;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.dashboard_fragment,container, false);

        //WindowCompat.setDecorFitsSystemWindows(getWindow(), false);

        recyclerViewTop1 = root.findViewById(R.id.recycler_view_top1);
        recyclerViewTop2 = root.findViewById(R.id.recycler_view_top2);
        recyclerViewBottom = root.findViewById(R.id.recycler_view_bottom);
        brandRView = root.findViewById(R.id.brands_rv);

        item = new ArrayList<>();
        LoadingData.putStaticsData(item);
        staticRVAdapter = new StaticRVAdapter(item);
        recyclerViewTop1.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewTop1.setAdapter(staticRVAdapter);

        recyclerViewTop2.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        recyclerViewTop2.setAdapter(staticRVAdapter);

        brands = new ArrayList<>();
        LoadingData.putBrandsData(brands);
        brandsRVAdapter = new BrandsRVAdapter(brands);
        brandRView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false));
        brandRView.setAdapter(brandsRVAdapter);

        items = new ArrayList<>();
        LoadingData.putDynamicData(items);
        recyclerViewBottom.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL, false));
        dynamicRVAdapter = new DynamicRVAdapter(recyclerViewBottom, getActivity(), items);
        recyclerViewBottom.setAdapter(dynamicRVAdapter);

        dynamicRVAdapter.setLoadMore(new LoadMore() {
            @Override
            public void onLoadMore() {
                if(items.size()<=10){
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

        Fragment fragment = new EndingFragment();
        getParentFragmentManager().beginTransaction()
                .replace(R.id.end_fragment_container, fragment, fragment.getClass().getSimpleName())
                .addToBackStack(null).commit();

        return root;
    }

    public void generateData(){
        for(int i=0 ; i<10 ; i++){
            String name = UUID.randomUUID().toString();
            items.add(new DynamicRVModel(name.substring(0,8)));
        }
    }
}
