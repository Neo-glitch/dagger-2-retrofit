package com.neo.daggerretrofit;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.neo.daggerretrofit.model.MainActivityViewModel;
import com.neo.daggerretrofit.model.RecyclerList;

public class MainActivity extends AppCompatActivity {

    private RvAdapter mAdapter;
    private MainActivityViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initRecyclerView();
    }

    public void initRecyclerView(){
        RecyclerView recyclerView = findViewById(R.id.recyler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        mAdapter = new RvAdapter();

        recyclerView.setAdapter(mAdapter);
        getData();
    }

    private void getData(){
        mViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mViewModel.getRecyclerListObserver().observe(this, new Observer<RecyclerList>() {
            @Override
            public void onChanged(RecyclerList recyclerList) {
                if(recyclerList != null){
                    mAdapter.setListData(recyclerList.getItems());
                } else{
                    Toast.makeText(MainActivity.this, "Unable to get data, check your internet", Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
        mViewModel.makeApiCall();
    }
}