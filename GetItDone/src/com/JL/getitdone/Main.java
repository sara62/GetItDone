package com.JL.getitdone;

import java.util.ArrayList;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class Main extends Activity {
	
	private Context context = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ListView listView = (ListView) findViewById(R.id.list);
        DeadlineListAdapter deadlineListAdapter = new DeadlineListAdapter(this, generateData());
        
        Button AddButton = new Button(this);
        AddButton.setText("Add");
        
        Button DeleteButton = new Button(this);
        DeleteButton.setText("Add");
        
        listView.addFooterView(AddButton); 
        listView.addFooterView(DeleteButton); 
        
        listView.setAdapter(deadlineListAdapter);
        

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private ArrayList<TaskRecord> generateData(){
    ArrayList<TaskRecord> tasks = new ArrayList<TaskRecord>();
    tasks.add(new TaskRecord("Assignment 4", "Oct 2, 2013", "Physics"));
    tasks.add(new TaskRecord("Assignment 5", "Oct 2, 2013", "Math"));
    tasks.add(new TaskRecord("Lab Report 4", "Oct 2, 2013", "140"));
    
    return tasks;
    }
}
