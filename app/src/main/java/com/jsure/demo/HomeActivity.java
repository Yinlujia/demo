package com.jsure.demo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    ListView lv_list;
    MyAdapter myAdapter;
    List<Item> itemList;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_list = findViewById(R.id.lv_list);

        myAdapter = new MyAdapter(this);
        lv_list.setAdapter(myAdapter);
        lv_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(HomeActivity.this, "您点击了条目"+position, Toast.LENGTH_SHORT).show();
//                Item item = itemList.get(position);
//                Intent intent = new Intent(HomeActivity.this, MainActivity.class);
//                intent.
//                startActivity(intent);
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

        myAdapter.setData(itemList);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
