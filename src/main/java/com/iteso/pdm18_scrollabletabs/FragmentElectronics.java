package com.iteso.pdm18_scrollabletabs;


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


public class FragmentElectronics extends Fragment {


    RecyclerView recyclerView;

    public FragmentElectronics() {
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

        ArrayList<ItemProduct> products = new ArrayList<>();
        products.add(new ItemProduct("Refrigerador", "BestBuy", "Zapopan", "3312345678", "Lorem Ipsum ....", Constant.TYPE_REFRIGERATOR, 2));
        products.add(new ItemProduct("Micro", "Palacio de Hierro", "Zapopan", "3312345678", "Lorem Ipsum ....", Constant.TYPE_MICRO, 2));

        AdapterProduct adapterProduct = new AdapterProduct(getActivity(), products);
        recyclerView.setAdapter(adapterProduct);
    }

}
