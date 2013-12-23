package com.JL.getitdone;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;

public class Main extends Activity {

	private Context context = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ListView listView = (ListView) findViewById(R.id.list);
		DeadlineListAdapter deadlineListAdapter = new DeadlineListAdapter(this,
				generateData());

		//Set Footer
		LayoutInflater inflater = this.getLayoutInflater();
		LinearLayout listFooterView = (LinearLayout) inflater.inflate(
				R.layout.footer, null);

		listView.addFooterView(listFooterView);

		listView.setAdapter(deadlineListAdapter);

		listView.setOnItemClickListener( new OnItemClickListener() {
		    public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		        Intent click = new Intent(Main.this,EditDeadlineActivity.class);
		        startActivity(click);
		    }
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	private ArrayList<TaskRecord> generateData() {
		ArrayList<TaskRecord> tasks = new ArrayList<TaskRecord>();
		tasks.add(new TaskRecord("Assignment 4", "Oct 2, 2013", "Physics"));
		tasks.add(new TaskRecord("Assignment 5", "Oct 2, 2013", "Math"));
		tasks.add(new TaskRecord("Lab Report 4", "Oct 2, 2013", "140"));
		tasks.add(new TaskRecord("Lab Report 4", "Oct 2, 2013", "140"));
		tasks.add(new TaskRecord("Lab Report 4", "Oct 2, 2013", "140"));
		tasks.add(new TaskRecord("Lab Report 4", "Oct 2, 2013", "140"));
		tasks.add(new TaskRecord("Lab Report 4", "Oct 2, 2013", "140"));
		tasks.add(new TaskRecord("Lab Report 4", "Oct 2, 2013", "140"));
		tasks.add(new TaskRecord("Lab Report 4", "Oct 2, 2013", "140"));
		tasks.add(new TaskRecord("Lab Report 4", "Oct 2, 2013", "140"));
		tasks.add(new TaskRecord("Lab Report 4", "Oct 2, 2013", "140"));
		tasks.add(new TaskRecord("Lab Report 4", "Oct 2, 2013", "140"));

		return tasks;
	}

}
