package com.neo.daggerretrofit.model;


import java.util.ArrayList;

// maps response gotten from server
public class RecyclerList {

    private ArrayList<RecyclerData> items;

    public ArrayList<RecyclerData> getItems() {
        return items;
    }

    public void setItems(ArrayList<RecyclerData> items) {
        this.items = items;
    }

    public RecyclerList(ArrayList<RecyclerData> items) {
        this.items = items;
    }
}
