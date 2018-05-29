package cegeka.scoaladevalori.ro.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ToDoListActivity extends AppCompatActivity {

    ListView mListView = null;
    List<String> adapterList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_to_do_list);
        mListView = findViewById(R.id.listView);
        adapterList = new ArrayList<>();
        for(ToDoItem item : LoginActivity.mList){
            adapterList.add(item.title + " " + item.description);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(ToDoListActivity.this,
                R.layout.single_item,
                R.id.textView2,
                adapterList);
        mListView.setAdapter(adapter);
    }
}
