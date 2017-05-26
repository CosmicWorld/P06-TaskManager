package com.example.a15017381.p06_taskmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by 15017381 on 26/5/2017.
 */

public class TaskArrayAdapter extends ArrayAdapter<Task> {
    Context context;
    ArrayList<Task> tasks;
    TextView tvName, tvContent;
    int resource;

    public TaskArrayAdapter(Context context, int resource, ArrayList<Task> tasks) {
        super(context, resource, tasks);
        this.context = context;
        this.tasks = tasks;
        this.resource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(resource, parent, false);

        tvName = (TextView)rowView.findViewById(R.id.textViewName);
        tvContent = (TextView)rowView.findViewById(R.id.textViewContent);

        Task task = tasks.get(position);
        tvName.setText((position+1)+" "+task.getName());
        tvContent.setText(task.getContent());

        return rowView;
    }
}
