package com.msiazn.recycleviewtutorial;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<ModelItem> list;

    RecyclerView recyclerView;
    ModelItemAdapter adapter;
    RecyclerView.LayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();

        list.add(new ModelItem("Titel 0", "Description 0", R.drawable.ic_android));
        list.add(new ModelItem("Titel 1", "Description 1", R.drawable.ic_android));
        list.add(new ModelItem("Titel 2", "Description 2", R.drawable.ic_android));
        list.add(new ModelItem("Titel 3", "Description 3", R.drawable.ic_android));
        list.add(new ModelItem("Titel 4", "Description 4", R.drawable.ic_android));
        list.add(new ModelItem("Titel 5", "Description 5", R.drawable.ic_android));
        list.add(new ModelItem("Titel 6", "Description 6", R.drawable.ic_android));
        list.add(new ModelItem("Titel 7", "Description 7", R.drawable.ic_android));
        list.add(new ModelItem("Titel 8", "Description 8", R.drawable.ic_android));
        list.add(new ModelItem("Titel 9", "Description 9", R.drawable.ic_android));
        list.add(new ModelItem("Titel 10", "Description 10", R.drawable.ic_android));
        list.add(new ModelItem("Titel 11", "Description 11", R.drawable.ic_android));
        list.add(new ModelItem("Titel 12", "Description 12", R.drawable.ic_android));
        list.add(new ModelItem("Titel 13", "Description 13", R.drawable.ic_android));
        list.add(new ModelItem("Titel 14", "Description 14", R.drawable.ic_android));
        list.add(new ModelItem("Titel 15", "Description 15", R.drawable.ic_android));
        list.add(new ModelItem("Titel 16", "Description 16", R.drawable.ic_android));
        list.add(new ModelItem("Titel 17", "Description 17", R.drawable.ic_android));
        list.add(new ModelItem("Titel 18", "Description 18", R.drawable.ic_android));
        list.add(new ModelItem("Titel 19", "Description 19", R.drawable.ic_android));
        list.add(new ModelItem("Titel 20", "Description 20", R.drawable.ic_android));


        recyclerView = findViewById(R.id.recyclerView);
        adapter = new ModelItemAdapter(list);
        manager = new LinearLayoutManager(this);

        adapter.setOnItemClickListener(new ModelItemAdapter.OnItemClickListener() {
            @Override
            public void onItemClicked(int position) {
                makeToast(position);
            }
        });

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(adapter);


    }

    private void makeToast(int pos) {
        Toast.makeText(this, "Position is" + pos, Toast.LENGTH_SHORT).show();
    }
}
