package com.jsure.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lv_list;
    ListAdapter listAdapter;
    List<Item> itemList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_list = findViewById(R.id.lv_list);

        listAdapter = new ListAdapter(this);
        lv_list.setAdapter(listAdapter);
        lv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "点击了条目" + itemList.get(position).getTitle(), Toast.LENGTH_SHORT).show();
            }
        });

        initData();
    }

    public void initData() {
        itemList = new ArrayList<>();
        for (int i = 0; i < 20; i ++) {
            Item item = new Item();
            item.setTitle("title name-" + i);
            item.setContent("title content---" + i);
            item.setTime("2018-12-"+i);
            itemList.add(item);
        }

        listAdapter.setData(itemList);
    }
}
