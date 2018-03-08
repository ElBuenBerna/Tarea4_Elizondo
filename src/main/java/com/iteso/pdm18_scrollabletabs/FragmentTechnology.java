package com.iteso.pdm18_scrollabletabs;


import android.content.ClipData;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.iteso.pdm18_scrollabletabs.beans.ItemProduct;
import com.iteso.pdm18_scrollabletabs.tools.Constant;

import java.util.ArrayList;
import java.util.Iterator;

public class FragmentTechnology extends Fragment {

    RecyclerView.Adapter mAdapter;
    ArrayList<ItemProduct> products;
    RecyclerView recyclerView;

    public FragmentTechnology() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_technology, container, false);
        recyclerView = rootView.findViewById(R.id.fragment_recycler);
        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        recyclerView.setHasFixedSize(true);
        // Use a linear layout manager
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

        products = new ArrayList<>();
        products.add(new ItemProduct("Mac", "BestBuy", "Zapopan", "3312345678", "Lorem Ipsum ....", Constant.TYPE_MAC, 1));
        products.add(new ItemProduct("Alienware", "DELL", "Zapopan", "3312345678", "Lorem Ipsum ....", Constant.TYPE_ALIENWARE, 1));
        products.add(new ItemProduct("Lanix", "Saint Jhonny", "Zapopan", "3312345678", "Lorem Ipsum ....", Constant.TYPE_LANIX, 1));

        mAdapter = new AdapterProduct(getActivity(), products);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        ItemProduct itemProduct=data.getParcelableExtra("ITEM");
        Iterator<ItemProduct> iterator= products.iterator();
        int position=0;
        while(iterator.hasNext()){
            ItemProduct item= iterator.next();;
            if(item.getCode()== itemProduct.getCode()){
                products.set(position,itemProduct);
                break;
            }
            position++;

        }
        mAdapter.notifyDataSetChanged();
    }


}
