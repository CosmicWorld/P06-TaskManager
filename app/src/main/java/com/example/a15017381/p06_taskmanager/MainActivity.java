package com.example.a15017381.p06_taskmanager;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lvTask;
    Button buttonAdd;
    ArrayList<Task> taskArrayList;
    ArrayAdapter aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvTask = (ListView)findViewById(R.id.lvTask);
        buttonAdd = (Button)findViewById(R.id.buttonAdd);

        DBHelper db = new DBHelper(MainActivity.this);
        taskArrayList = db.getAllTasks();

        aa = new TaskArrayAdapter(MainActivity.this, R.layout.row, taskArrayList) ;
        lvTask.setAdapter(aa);

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getBaseContext(),AddActivity.class);
                startActivityForResult(i,9);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK){
            if(data != null){
                if(requestCode == 9 || requestCode == 8) {
                    DBHelper dbh = new DBHelper(MainActivity.this);
                    taskArrayList.clear();
                    taskArrayList.addAll(dbh.getAllTasks());
                    dbh.close();
                    aa.notifyDataSetChanged();
                }
            }
        }
    }
}
