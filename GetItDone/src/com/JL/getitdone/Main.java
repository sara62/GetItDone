package com.JL.getitdone;

import java.util.ArrayList;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

public class Main extends Activity {

	private Context context = null;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		ListView listView = (ListView) findViewById(R.id.list);
		DeadlineListAdapter deadlineListAdapter = new DeadlineListAdapter(this,
				generateData());

		listView.setAdapter(deadlineListAdapter);

		//Click on a row
		listView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> myAdapter, View view, int position,
					long arg3) {

				final String[] options_array = { "Add", "Edit", "Delete" };
				AlertDialog.Builder builder = new AlertDialog.Builder(Main.this);
				builder.setTitle(R.string.name).setItems(options_array,
						new DialogInterface.OnClickListener() {

							@Override
							public void onClick(DialogInterface dialog,
									int which) {
								// TODO Auto-generated method stub
								if (which == 0) {
									Toast.makeText(getApplicationContext(),
											"Added successfully",
											Toast.LENGTH_LONG).show();
								} else if (which == 1) {
									Intent click = new Intent(Main.this,
											EditDeadlineActivity.class);
									startActivity(click);

								} else {
									Toast.makeText(getApplicationContext(),
											"Deleted succesfully",
											Toast.LENGTH_LONG).show();
								}
							}
						});
				builder.create();
				builder.show();
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
