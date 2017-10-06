package aquil.recycleviewdemo;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ListActivity extends Activity {

    RecycleViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ArrayList<String> listData = new ArrayList<>();
        listData.add("Alex");
        listData.add("Marty");
        listData.add("Melman");
        listData.add("Gloria");
        listData.add("Julien");
        listData.add("Skipper");
        listData.add("Maurice");
        listData.add("Mort");
        listData.add("Gia");

        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.rclView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecycleViewAdapter(ListActivity.this,listData);
        recyclerView.setAdapter(adapter);


    }
}
